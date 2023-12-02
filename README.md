# 빗썸 api 호출 

api문서:https://apidocs.bithumb.com/reference/%ED%98%B8%EA%B0%80-%EC%A0%95%EB%B3%B4-%EC%A1%B0%ED%9A%8C


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

** 앞으로 할일 **
1.유튜브api,공공데이터api,네이버 api 등을 recyclerview에 표시해봅니다,
2.서버와 통신하여 받아와서 recyclerview에 표시된 데이터들을 다른 fragment or activity에 보낸뒤 표시해봅니다. (데이터전달 intent or bundle)
3.데이터를 저장하고,출력 해봅니다 ( Room, Sharedpreferences )
4.viewModel을 사용하고, mvvm 아키텍쳐로 코드를 리팩토링합니다. (본프로젝트 시에)
