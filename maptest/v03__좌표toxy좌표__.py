import pandas as pd
import numpy as np
import requests


def get_coordinates(address):
    url = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode"
    headers = {
        "X-NCP-APIGW-API-KEY-ID": "cllsw53gb0",
        "X-NCP-APIGW-API-KEY": "ORE1ichm7zV9lqctMCyjr3sDumov4lwTKf5Khash"
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
add_coordinates_and_save('./maptest/test.csv', './maptest/testresult.csv')