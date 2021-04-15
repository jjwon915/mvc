# mvc 구조.
* Model : Java Class로 Business Logic 구현
* View : JSP, client에게 보이는 부분.
* Controller : Servlet으로 Client가 보낸 요청을 받고 Parameter를 수집하는 작업을 한다. 
  - get방식은 넘어가는 값이 모두 보인다. 따라서 보안에 취약하다. url로 서버에 넘기기 때문에 많은 양의 데이터를 넘기기는 어렵다. 
  - post방식은 넘어가는 값이 보이지 않는다. packet으로 쌓아서 데이터를 네트워크로 전송하기 때문에 데이터 양의 한계가 없으며 보안이 좋다.
  - Client가 요청을 하면, Tomcat Server가 요청객체인 HttpServletRequest과 응답객체인 HttpServletResponse를 만들고 client의 식별을 위해 packet의 헤더부분(client의 정보)을 저장한다. Business Logic 처리 후 응답시 Response 객체에 담긴 Client의 정보를 통해 응답한다. 
