import requests
apiurl = "http://api.vworld.kr/req/address?"
params = {
    "service": "address",
    "request": "getcoord",
    "crs": "epsg:4326",
    "address": "서울특별시 서초구 신반포로23길 41, 4층 404호 (잠원동, 신반포2지구아파트)",
    "format": "json",
    "type": "road",
    "key": "2681FF63-DDC8-3335-B51D-12E180F0B41E"
}
response = requests.get(apiurl, params=params)
if response.status_code == 200:
    print(response.json())

