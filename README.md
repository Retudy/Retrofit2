# 빗썸 api 호출 
## 작성자: youneeo

구조<br/>

View: CoinActivity, activity_coin (xml)<br/>
Data Class: Ticker,Data<br/>
interface: Apiservice<br/><br/>
CoinActivity에서
<br/>
1.Retrofit 객체초기화<br/>
2.service 객체생성<br/>
3.Call 객체 생성<br/>
4.네트워크 통신<br/>

을통해서 EditText 에 입력받은 값을 통해서 textView에 표시합니다.<br/>
필요한 데이터는 response.body() 를 통해 꺼내오게 됩니다.<br/>

CoinActivity 를 실행하고 editText에 코인정보를 입력하고, 조회버튼을 누르면 조회됩니다.<br/><br/>

실행화면<br/><br/>

<img width="322" alt="스크린샷 2023-12-03 오전 6 10 10" src="https://github.com/Retudy/Retrofit2/assets/129308578/d2c2a88a-8c18-44f9-9396-c19352dbcd32"><br/>


api문서:https://apidocs.bithumb.com/reference/%ED%98%B8%EA%B0%80-%EC%A0%95%EB%B3%B4-%EC%A1%B0%ED%9A%8C<br/>
참고:https://www.youtube.com/watch?v=YKV1a1YkuKE

