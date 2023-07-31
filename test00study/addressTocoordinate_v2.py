import requests
import pandas as pd

def address_to_coordinates(address):
    apiurl = "http://api.vworld.kr/req/address?"
    params = {
        "service": "address",
        "request": "getcoord",
        "crs": "epsg:4326",
        "address": address,
        "format": "json",
        "type": "road",
        "key": "2681FF63-DDC8-3335-B51D-12E180F0B41E"  # You may need to replace this with your own API key
    }
    response = requests.get(apiurl, params=params)
    if response.status_code == 200:
        data = response.json()
        return (data['response']['result']['point']['x'], data['response']['result']['point']['y'])
    else:
        return None
    
address = "서울특별시 서초구 신반포로23길 41, 4층 404호 (잠원동, 신반포2지구아파트)"
address = "서울특별시 강북구 인수동로 76길 7-7 웰하우스 201호"
coordinates = address_to_coordinates(address)
print(coordinates)



import csv

# CSV 파일 경로 설정
csv_file_path = './tmp_test/test.csv'

# 주소를 담을 빈 배열 선언
address_list = []

# CSV 파일 열기
with open(csv_file_path, newline='', encoding='utf-8') as csvfile:
    # CSV 데이터 읽기
    csv_reader = csv.DictReader(csvfile)
    
    # 주소 데이터 배열에 담기
    for row in csv_reader:
        address = row['주소']
        print(address)
        # crd = address_to_coordinates(address)
        # address_list.append(crd)

# 결과 출력
print(address_list)
