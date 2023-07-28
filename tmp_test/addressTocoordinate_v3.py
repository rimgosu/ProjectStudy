import requests

locations = []
for addr in addrs:
    url = 'https://dapi.kakao.com/v2/local/search/address.json?query={}'.format(addr)
    headers = {
    ## 여러분의 카카오 API의 REST API키를 아래 예시와 같이 입력해주세요
    ## "Authorization": "KakaoAK REST API키 입력 gogo"}
    "Authorization": "KakaoAK f64acb1ae8c66asdfasefasfasdfadsf"}
    place = requests.get(url, headers = headers).json()['documents']
    locations.append(place)