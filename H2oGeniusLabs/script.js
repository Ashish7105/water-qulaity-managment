document.addEventListener("DOMContentLoaded", function () {
    const dataContainer = document.getElementById("dataContainer");

    // Replace this URL with your real-time data API endpoint
    const apiUrl = "https://api.example.com/realtime-data";

    // Fetch real-time data
    async function fetchRealTimeData() {
        try {
            const response = await fetch(apiUrl);
            const data = await response.json();
            displayRealTimeData(data);
        } catch (error) {
            console.error("Error fetching real-time data:", error);
        }
    }

    // Display real-time data
    function displayRealTimeData(data) {
        // Customize this part based on your data structure
        const html = `
            <p>Temperature: ${data.temperature} °C</p>
            <p>pH Level: ${data.phLevel}</p>
            <!-- Add more data points as needed -->
        `;
        dataContainer.innerHTML = html;
    }

    // Fetch and display real-time data on page load
    fetchRealTimeData();

    // Refresh data every 5 seconds (adjust as needed)
    setInterval(fetchRealTimeData, 5000);
});
