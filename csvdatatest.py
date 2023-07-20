import csv

# CSV 파일 열기
with open('./gymdata/testcsvdata.csv', 'r') as file:
    # CSV 데이터를 읽을 때 사용할 구분자 지정 (기본값은 쉼표)
    csv_reader = csv.reader(file)

    # 각 줄마다 데이터 읽기
    for row in csv_reader:
        # 각 행의 데이터에 접근하여 작업 수행
        print(row)  # 예시로 각 행을 출력하는 것

# 파일 닫기
file.close()

