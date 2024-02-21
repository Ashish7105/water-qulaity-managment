#include <WiFi.h>
#include <HTTPClient.h>
#include <ThingSpeak.h>

const char* ssid = "poco";
const char* password = "password11";
const char* serverName = "http://api.thingspeak.com/update";
String apiKey = "CBV3F9P1AMHGT87L";
const int turbiditySensorPin = A0;
const long channelId = 2403192; // Replace with your ThingSpeak channel ID

WiFiClient client; 

void setup() {
  Serial.begin(115200);
  WiFi.begin(ssid, password);

  Serial.println("Connecting");
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.print("Connected to WiFi network with IP Address: ");
  Serial.println(WiFi.localIP());
}

void loop() {
  if (WiFi.status() == WL_CONNECTED) {
    // Read turbidity sensor
    int turbidityValue = analogRead(turbiditySensorPin);

    // Convert the sensor value to turbidity level or other appropriate unit
    float turbidityLevel = map(turbidityValue, 0, 1023, 0, 100);

    // Print the turbidity level to the Serial Monitor
    Serial.print("Turbidity Level: ");
    Serial.println(turbidityLevel);

    // Update ThingSpeak channel with turbidity data
    ThingSpeak.begin(client);
    ThingSpeak.writeField(static_cast<unsigned long>(channelId), 1, turbidityLevel, apiKey.c_str());

    // Wait for a specific interval before sending the next update
    delay(15000);
  }
}