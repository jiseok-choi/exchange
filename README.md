# 환율 계산 프로그램



## 프로젝트 환경

- Spring Web MVC

- Vue.js

- jdk 11


## 화면

![image](https://user-images.githubusercontent.com/53139084/165005188-7925700a-da2d-431d-8047-6977898fec50.png)




## 프로젝트 구조


![image](https://user-images.githubusercontent.com/53139084/165004827-4385be4c-aeaf-47aa-a80a-3f6c8fb7045b.png)



- 프로젝트가 실행되었을때 외부 API 를 통해 환율정보를 가져옵니다.
  
  - 외부 API 는 1시간 마다 요청하여 데이터를 가져옵니다.

- Web Application 의 주소는 localhost:8080 입니다.

- 프로젝트를 git clone 할 시 Web view 빌드파일이 내장 되어 있어 localhost:8080 으로 접근해도 화면을 볼 수 있습니다.

- Web view (Vue.js) 프로젝트는 /프로젝트 root 경로/vue/exchange-front/ 에 위치합니다.
  
  - npm install 후 npm run serve 를 통해 실행할 수 있으며 접근 정보는 localhost:8090 입니다.
  
  - npm run build 시 빌드 위치는 Web Application 에 내장되도록 경로가 설정되어 있습니다.

- Web view 에서 국가를 선택할 때 해당 국가의 환율정보를 요청합니다.

- submit 버튼을 클릭시 화면에 보여진 환율 대로 계산되어 수취 금액을 확인할 수 있습니다.

- 송금액은 0 ~ 10,000 을 입력할 수 있습니다.
















