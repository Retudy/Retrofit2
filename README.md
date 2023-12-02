# 빗썸 api 호출 

구조

View: CoinActivity, activity_coin (xml)
Data Class: Ticker,Data
interface: Apiservice


CoinActivity에서

1.Retrofit 객체초기화
2.service 객체생성
3.Call 객체 생성
4.네트워크 통신

을통해서 EditText 에 입력받은 값을 통해서 textView에 표시합니다.

필요한 데이터는 response.body() 를 통해 꺼내오게 됩니다.

작성자: youneeo


CoinActivity 를 실행하고 editText에 코인정보를 입력하고, 조회버튼을 누르면 조회됩니다.

실행화면

<img width="322" alt="스크린샷 2023-12-03 오전 6 10 10" src="https://github.com/Retudy/Retrofit2/assets/129308578/d2c2a88a-8c18-44f9-9396-c19352dbcd32">
