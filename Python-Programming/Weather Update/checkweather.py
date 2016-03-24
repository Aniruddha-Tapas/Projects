#! python3
# quickWeather.py - Prints the current weather for a location from the command line.

import json, requests, sys

appID = '833f67c8c998811130576a8d4b37c49c'
location = ('Nagpur,IN')

# Download the JSON data from OpenWeatherMap.org's API
url ='http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s' % (location, appID)
response = requests.get(url)
response.raise_for_status()

# Load JSON data into a Python variable.
weatherData = json.loads(response.text)
# Print weather descriptions.
w = weatherData['weather']

print('Current weather in %s:' % (location))
print(w[0]['main'], '-', w[0]['description'])

# Print temperature.
t = weatherData['main']
temp = t["temp"]-273.15
print('Temperature - %.2f\'C' %(temp))
