import pandas as pd
import numpy as np
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

def add_coordinates_and_save(input_csv, output_csv):
    # Load the CSV file
    data = pd.read_csv(input_csv)

    # Get coordinates for each address
    coordinates = data['주소'].apply(get_coordinates)
    data['y좌표'], data['x좌표'] = zip(*coordinates)

    # Save the modified dataframe to a new CSV file
    data.to_csv(output_csv, index=False)
    print(f"Saved data to {output_csv}")

# Test the function
add_coordinates_and_save('./test02map/test.csv', './test02map/testresult.csv')