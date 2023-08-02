import requests
import json

# Load the JSON file
with open('C:/keys.json', 'r') as f:
    data = json.load(f)

# Extract the needed values
naverMapID = None
naverMapPassword = None
keys = data.get('keys')

for key in keys:
    if 'naverMapID' in key:
        naverMapID = key['naverMapID']
    if 'naverMapPassword' in key:
        naverMapPassword = key['naverMapPassword']

def get_coordinates(address):
    url = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode"
    headers = {
        "X-NCP-APIGW-API-KEY-ID": naverMapID,
        "X-NCP-APIGW-API-KEY": naverMapPassword
    }
    params = {"query": address}
    
    response = requests.get(url, headers=headers, params=params)
    
    if response.status_code == 200:
        items = response.json()["addresses"]
        if items:
            x = items[0]["x"]
            y = items[0]["y"]
            return x, y
        else:
            return None, None
    else:
        raise Exception(f"Error occurred: {response.status_code}")

# Test the function
x, y = get_coordinates("경기도 광주시 경안동 123-4")
print(f"Coordinates: ({x}, {y})")