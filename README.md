# mvc 구조.
* Model : Java Class로 Business Logic 구현
* View : JSP, client에게 보이는 부분.
* Controller : Servlet으로 Client가 보낸 요청을 받고 Parameter를 수집하는 작업을 한다. 
  - get방식 
    - 넘어가는 값이 모두 보인다. 따라서 보안에 취약하다. url로 서버에 넘기기 때문에 많은 양의 데이터를 넘기기는 어렵다. <a> 태그에서 많이 사용한다. get방식으로 넘길 때는 **querystring** 형태로 구성되어있으며 ?변수=값&변수=값&변수=값 이런 식이다. 공백이 있으면 안된다. 
  - post방식 
    - 넘어가는 값이 보이지 않는다. packet으로 쌓아서 데이터를 네트워크로 전송하기 때문에 데이터 양의 한계가 없으며 보안이 좋다. <form> 에서는 대부분 Post 방식.
    - Client가 요청을 하면, Tomcat Server가 요청객체인 HttpServletRequest과 응답객체인 HttpServletResponse를 만들고 client의 식별을 위해 packet의 헤더부분(client의 정보)을 저장한다. Business Logic 처리 후 응답시 Response 객체에 담긴 Client의 정보를 통해 응답한다. 
* WAS(Tomcat) : Controller(Servlet) + Model(Java) + DB(MySQL)
  - DB와 Model은 JDBC로 연결한다. 
  - Client가 요청을 보내면 Controller에서 요청을 받고, 처리는 Model에서 진행한 뒤 응답한다. 
