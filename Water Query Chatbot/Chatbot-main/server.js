const express = require('express');
const { GoogleGenerativeAI, HarmCategory, HarmBlockThreshold } = require('@google/generative-ai');
const dotenv = require('dotenv').config()
const app = express();
const port = process.env.PORT || 3000;
app.use(express.json());
const MODEL_NAME = "gemini-pro";
const API_KEY = process.env.API_KEY;
async function runChat(userInput) {
  const genAI = new GoogleGenerativeAI(API_KEY);
  const model = genAI.getGenerativeModel({ model: MODEL_NAME });
  const generationConfig = {
    temperature: 0.9,
    topK: 1,
    topP: 1,
    maxOutputTokens: 1000,
  };
  const safetySettings = [
    {
      category: HarmCategory.HARM_CATEGORY_HARASSMENT,
      threshold: HarmBlockThreshold.BLOCK_MEDIUM_AND_ABOVE,
    },
    // ... other safety settings
  ];
  const chat = model.startChat({
    generationConfig,
    safetySettings,
    history: [
        {
            "role": "user",
            "parts": ["Hi"]
          },
          {
            "role": "model",
            "parts": ["Hello! I m an AI. I am here to answer your queries related to water quality. You can know about pH, Conductance and Turbidity and check standard pH, Conductance and Turbidity value of Drinking Water. Also you can see the effects of drinking water of unbalanced pH, Conductance and Turbidity."]
          },
          {
            "role": "user",
            "parts": ["What is the Standard pH value of Drinking Water?"]
          },
          {
            "role": "model",
            "parts": ["Tap water typically has a pH level of 7.5, while common bottled waters have pH levels of 6.5 to 7.5. However, the human body maintains pH equilibrium on a constant basis and will not be affected by water consumption.\nThe ideal pH level of alkaline ionized water for long-term human consumption is between 8.5 and 9.5. The Canadian Guidelines for Drinking Water Quality suggest that the pH of drinking water should be between 7.0 and 10.5, while the Saskatchewan Drinking Water Standards and Objectives recommend that the pH of drinking water be between 6.5 and 9.0. The pH of human blood is a little on the basic side, 7.365."]
          },
          {
            "role": "user",
            "parts": ["What is the Standard Conductance value of Drinking Water?"]
          },
          {
            "role": "model",
            "parts": ["The conductivity value of drinking water ranges from 200 to 800 S/cm, according to sources 0 and 1. The range of conductivity varies between water bodies, with lakes and streams having a range of 0-200 S/cm, while major rivers can have a range of up to 1000 S/cm. Water with a conductivity value of 1000-10,000 S/cm indicates t8hat it is saline."]
          },
          {
            "role": "user",
            "parts": ["What is the Standard Turbidity value of Drinking water?"]
          },
          {
            "role": "model",
            "parts": ["The EPA Interim Primary Drinking Water Regulations recommend that the turbidity of potable water be less than 1 unit and less than 5 units under special conditions. \nMany drinking water utilities strive to achieve levels as low as 0.1 NTU."]
          },
          {
            "role": "user",
            "parts": ["What are the effects of drinking water of unbalanced pH value?"]
          },
          {
            "role": "model",
            "parts": ["1) Digestive Issues: Drinking water with extremely high or low pH levels may lead to gastrointestinal discomfort, including nausea, vomiting, and stomach cramps.\n2) Corrosion of Pipes: Water with low pH (acidic) can corrode plumbing and distribution systems, leading to the release of harmful metals like lead into the drinking water.\n3) Scaling: High pH (alkaline) water can contribute to scaling in pipes and appliances, reducing their efficiency and lifespan."]
          },
          {
            "role": "user",
            "parts": ["What are the effects of drinking water of unbalanced conductance value?"]
          },
          {
            "role": "model",
            "parts": ["1) Taste and Odor: Elevated conductance, often associated with high levels of dissolved minerals and salts, can impart an undesirable taste and odor to the water.\n2) Dehydration: Consuming water with high conductance levels may lead to increased thirst, as the dissolved salts can contribute to dehydration.\n3) Health Issues: Excessive intake of certain minerals like sodium, present in high conductance water, can pose health risks, especially for individuals with hypertension or cardiovascular conditions."]
          },
          {
            "role": "user",
            "parts": ["What are the effects of drinking water of unbalanced turbidity value?"]
          },
          {
            "role": "model",
            "parts": ["1) Gastrointestinal Distress: Turbid water may contain suspended particles, including bacteria and other microorganisms, leading to gastrointestinal issues and the risk of waterborne diseases.\n2) Aesthetic Concerns: Turbid water is visually unappealing and may have an unpleasant taste, affecting the overall acceptability of drinking water.\n3) Treatment Challenges: High turbidity levels can interfere with water treatment processes, making it more difficult to effectively remove contaminants and ensure water safety."]
          },
          {
            "role": "user",
            "parts": ["What is pH of water?"]
          },
          {
            "role": "model",
            "parts": ["The pH of pure water at 25 degrees Celsius (77 degrees Fahrenheit) is considered neutral and is defined as 7. A pH value below 7 indicates acidity, while a pH value above 7 indicates alkalinity. Keep in mind that the pH of water can be influenced by various factors, such as dissolved substances or contaminants. In natural environments, water pH can vary depending on factors like geological conditions, human activities, and the presence of organic matter."]
          },
          {
            "role": "user",
            "parts": ["What is Conductance of water?"]
          },
          {
            "role": "model",
            "parts": ["Conductance of water refers to its ability to conduct an electric current. Pure water itself is a poor conductor of electricity because it contains a very low concentration of ions (charged particles). The conductivity of water is mainly influenced by the presence of dissolved ions or salts. When salts are dissolved in water, they dissociate into positively and negatively charged ions, allowing the water to conduct electricity."]
          },
          {
            "role": "user",
            "parts": ["What is Turbidity of water?"]
          },
          {
            "role": "model",
            "parts": ["Turbidity is a measure of the cloudiness or haziness of a fluid caused by large numbers of individual particles that are generally invisible to the naked eye. In the context of water, turbidity is an important water quality parameter that indicates the presence of suspended particles such as clay, silt, algae, organic matter, and other fine particles. These particles scatter light, making the water appear cloudy or turbid."]
          },
          {
            "role": "user",
            "parts": ["What are the water quality testing methods?"]
          },
          {
            "role": "model",
            "parts": ["Water quality testing involves the analysis of various physical, chemical, and biological characteristics to assess the suitability of water for different purposes, such as drinking, industrial use, or recreational activities. Here are some common water quality testing methods:\n1) pH Measurement :\nMethod : pH meters or pH test kits.\nPurpose: Determines the acidity or alkalinity of water.\n2) Temperature Measurement :\nMethod: Thermometers or electronic temperature probes.\nPurpose : Monitors the temperature of the water, which can influence various chemical and biological processes.\n3) Conductivity Measurement : \nMethod : Conductivity meters.\nPurpose : Measures the ability of water to conduct an electric current, indicating the presence of dissolved ions.\n4) Turbidity Measurement :\nMethod : Nephelometers.\nPurpose : Assesses the cloudiness or haziness of water caused by suspended particles.\n5) Dissolved Oxygen (DO) Measurement :\nMethod : DO meters or chemical test kits.\nPurpose : Determines the amount of oxygen dissolved in water, which is crucial for aquatic life. \n6) Total Dissolved Solids (TDS) Measurement :\nMethod : TDS meters or gravimetric methods.\nPurpose : Measures the concentration of all dissolved substances in water, including salts and minerals.\n7) Nutrient Analysis (Nitrate, Phosphate, etc.) :\nMethod : Colorimetric methods or laboratory analysis.\nPurpose : Assesses nutrient levels, which can indicate pollution and impact water quality.\n8) Metals Analysis :\nMethod : Atomic absorption spectroscopy, inductively coupled plasma mass spectrometry (ICP-MS), or other spectroscopic methods.\nPurpose : Detects the presence of heavy metals, which can be toxic to humans and aquatic life.\n9) Bacterial Analysis :\nMethod : Membrane filtration, multiple-tube fermentation, or presence-absence tests.\nPurpose : Identifies the presence of coliform bacteria as indicators of fecal contamination.\n10) Biological Oxygen Demand (BOD) Measurement :\nMethod : Laboratory analysis.\nPurpose : Measures the amount of oxygen consumed by microorganisms while decomposing organic matter in water.\n11) Total Coliform and E. coli Testing :\nMethod : Presence-absence tests or membrane filtration.\nPurpose: Detects the presence of coliform bacteria and E. coli, indicating fecal contamination."]
          },
          {
            "role": "user",
            "parts": ["Why is water quality testing important?"]
          },
          {
            "role": "model",
            "parts": ["Water quality testing is crucial for many reasons, affecting our health, the environment, and even industries. Here's a breakdown of its importance :\n1) Protecting Human Health :\nPreventing illness : Contaminated water can harbor harmful bacteria, parasites, and chemicals that cause various illnesses, from mild gastrointestinal issues to serious diseases like cholera and typhoid. Testing identifies these contaminants, allowing for corrective measures to keep us safe. \nVulnerable populations : Children, pregnant women, the elderly, and immunocompromised individuals are at particular risk from waterborne diseases. Regular testing ensures their protection.\n2) Safeguarding the Environment :\nMonitoring ecosystems : Water quality testing helps assess the health of aquatic ecosystems, identifying pollutants that harm plants, animals, and overall ecological balance. This knowledge allows for better environmental management and conservation efforts.\nPollution prevention : Early detection of contamination sources like industrial waste or agricultural runoff allows for timely action to prevent further pollution and protect water resources.\n3) Supporting Industries and Agriculture :\nEnsuring safe use : Industries and agriculture rely on clean water for various processes. Testing guarantees the water is suitable for intended uses, preventing crop damage, machinery malfunction, and contamination of products.\nRegulatory compliance : Many industries and agricultural practices must adhere to water quality regulations. Testing proves compliance and avoids legal trouble.\n4) Further Advantages : \nBaseline data : Regular testing establishes a baseline for water quality, making it easier to identify future changes and potential problems.\nInformed decision-making : Test results empower individuals and authorities to make informed decisions about water use, treatment options, and infrastructure investments."]
          },
          {
            "role": "user",
            "parts": ["How frequently is water quality monitored and tested?"]
          },
          {
            "role": "model",
            "parts": ["The frequency of water quality monitoring and testing can vary greatly depending on several factors, including :\nType of water source : \n11) Drinking water : Public water supplies face the most stringent regulations and undergo frequent monitoring (daily, weekly, monthly) for various parameters like bacteria, chemicals, and pH.\n2) Private wells : Individual wells may be tested less frequently (annually or every few years) unless concerns arise like contamination or changes in taste or odor.\n3) Surface water (rivers, lakes, etc.) : Monitoring frequency depends on the water body's size, use, and vulnerability. Some lakes are tested daily, while others may be tested monthly or seasonally.\n4) Wastewater : Wastewater treatment plants typically have continuous monitoring systems for key parameters like pH and oxygen levels, with additional lab testing at regular intervals."]
          },
          {
            "role": "user",
            "parts": ["What specific parameters are tested in routine water quality assessments?"]
          },
          {
            "role": "model",
            "parts": ["Routine water quality assessments test for a range of physical, chemical, and biological parameters, including :\n1) Physical : Temperature ,Turbidity (cloudiness) , Color, Odor and taste.\nChemical : pH (acidity/alkalinity), Dissolved oxygen , Nutrients (nitrates, phosphates), Specific contaminants (metals, pesticides).\n3) Biological : Bacteria (E. coli, coliforms), Algae levels, Other indicators of ecosystem health."]
          },
          {
            "role": "user",
            "parts": ["How is the quality of groundwater monitored and protected?"]
          },
          {
            "role": "model",
            "parts": ["Groundwater quality is monitored and protected through :\n  \n1. Monitoring Wells : Regular sampling of wells strategically placed in aquifers.\n2) Regulatory Standards: Adherence to established water quality standards and regulations.\n3) Land Use Planning: Managing activities near aquifers to prevent contamination.\n4) Source Protection Plans: Developing plans to safeguard groundwater sources.\n5) Public Awareness: Educating communities on responsible water use and pollution prevention.\n6) Remediation: Implementing measures to clean up contaminated sites affecting groundwater."]
          },
          {
            "role": "user",
            "parts": ["what are effects of drinking water of unbalanced turbidity value?"]
          },
          {
            "role": "model",
            "parts": ["Unbalanced turbidity levels in drinking water can have various effects:\n\n**1. Health Risks:**\n\n   - Increased Microbial Contamination: High turbidity can provide a favorable environment for microorganisms, including bacteria, viruses, and parasites, to thrive. Consuming such water increases the risk of contracting waterborne diseases like gastroenteritis, cholera, and cryptosporidiosis.\n\n   - Interference with Disinfection: Turbid water can interfere with the effectiveness of disinfection processes, reducing the ability of disinfectants to inactivate pathogens. This can lead to an elevated risk of microbial contamination in drinking water.\n\n**2. Aesthetic Concerns:** \n\n   - Unpleasant Taste and Odor: High turbidity can impart an unpleasant taste and odor to drinking water, making it less palatable. This can discourage people from consuming adequate amounts of water, leading to potential health issues related to dehydration.\n\n**3. Elevated Treatment Costs:** \n\n   - Increased Treatment Demand: Water treatment plants must work harder to remove particles and microorganisms from highly turbid water. This requires additional chemicals, energy, and specialized treatment processes, resulting in higher treatment costs.\n\n**4. Distribution System Issues:**\n\n   - Sediment Accumulation: Excessive turbidity can lead to sedimentation and the accumulation of particles in pipes and distribution systems. This can clog filters, reduce water flow, and increase the risk of microbial contamination.\n\n   - Corrosion and Leakage: High turbidity can contribute to corrosion in water distribution systems, leading to leaks and reduced water quality.\n\n**5. Environmental Impact:**\n\n   - Increased Turbidity in Water Bodies: Elevated turbidity levels in drinking water sources can have ecological consequences. It can affect aquatic life, disrupt food chains, and hinder the overall health of the ecosystem."]
          },
    ],
  });
  const result = await chat.sendMessage(userInput);
  const response = result.response;
  return response.text();
}
app.get('/', (req, res) => {
  res.sendFile(__dirname + '/index.html');
});
app.get('/loader.gif', (req, res) => {
  res.sendFile(__dirname + '/loader.gif');
});
app.post('/chat', async (req, res) => {
  try {
    const userInput = req.body?.userInput;
    console.log('incoming /chat req', userInput)
    if (!userInput) {
      return res.status(400).json({ error: 'Invalid request body' });
    }
    const response = await runChat(userInput);
    res.json({ response });
  } catch (error) {
    console.error('Error in chat endpoint:', error);
    res.status(500).json({ error: 'Internal Server Error' });
  }
});
app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});