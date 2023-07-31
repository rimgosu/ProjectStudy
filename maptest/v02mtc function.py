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

# Test the function
x, y = get_coordinates("경기도 광주시 경안동 123-4")
print(f"Coordinates: ({x}, {y})")