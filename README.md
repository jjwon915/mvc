# mvc Model Project
- 2021.04
- 웹개발자로서 취준을 시작하며 MVC모델에 대해 제대로 이해하고 싶어 진행하게 되었다. 

1. MVC01 : Model과 Controller를 이용하여 회원정보 관리 프로젝트를 구현했다. Model은 Business Logic을 처리하고, Controller는 사용자의 요청을 받아 Model에서 처리할 수 있도록 한다. MVC01 프로젝트를 진행하며 느낀 것은 Controller 즉, 서블릿으로 View를 구현하는 것은 정말 비효율적이라고 느꼈다. 사용자가 보낸 parameter의 값을 받아 처리하는 과정을 제대로 이해할 수 있게된 것 같다. 
2. MVC02 : MVC01에서 구현한 기능들을 Model1방식인 JSP와 Model 이용해서 구현한 프로젝트이다. View에서 모든 Business Logic을 처리한다는 것 또한 비효율적이라고 생각이 되었다. 하지만 서블릿에서 모든 View를 구현했던 MVC01 프로젝트보다는 그나마 효율적으로 진화했다고 생각한다. Client에게 보여지지 않지만 처리를 담당하는 JSP인 Controller JSP와 Client에게 보여지는 JSP로 나눠서 구현했다.

* Model : Java Class로 Business Logic을 구현하는 부분이다.
* View : JSP, client에게 보이는 부분이다.
* Controller : Servlet으로 Client가 보낸 요청을 받고 Parameter를 수집하는 작업을 한다. 
  - get방식 
    - 넘어가는 값이 모두 보인다. 따라서 보안에 취약하다. url로 서버에 넘기기 때문에 많은 양의 데이터를 넘기기는 어렵다. <a> 태그에서 많이 사용한다. get방식으로 넘길 때는 **querystring** 형태로 구성되어있으며 ?변수=값&변수=값&변수=값 이런 식이다. 공백이 있으면 안된다. 
  - post방식 
    - 넘어가는 값이 보이지 않는다. packet으로 쌓아서 데이터를 네트워크로 전송하기 때문에 데이터 양의 한계가 없으며 보안이 좋다. <form> 에서는 대부분 Post 방식.
    - Client가 요청을 하면, Tomcat Server가 요청객체인 HttpServletRequest과 응답객체인 HttpServletResponse를 만들고 client의 식별을 위해 packet의 헤더부분(client의 정보)을 저장한다. Business Logic 처리 후 응답시 Response 객체에 담긴 Client의 정보를 통해 응답한다. 
* WAS(Tomcat) : Controller(Servlet) + Model(Java) + DB(MySQL)
  - DB와 Model은 JDBC로 연결한다. 
  - Client가 요청을 보내면 Controller에서 요청을 받고, 처리는 Model에서 진행한 뒤 응답한다. 

* redirect 
  - response.sendRedirect("/MVC01/memberList.do");
  - 서버가 다른 Controller에게 요청을 돌려서 응답하도록 하는 것을 의미한다. 따라서 앞의 코드에서는 memberListController가 응답하게 된다. 

* JSP(Java Server Page) / Servlet(Servlet + let)
  - Servlet은 100% 자바로 된 웹 프로그래밍
  - JSP는 View / Servlet은 Controller
  - JSP 구성요소 : HTML 태그요소 + 프로그래밍적 요소(<% %>) 혼합
    - <%@ page %> : page 지시자, Tomcat server에게 jsp라고 알려준다.
    - <%@ include %> : include 지시자
    - <%@ taglib %> : tag lib 지시자
    - <% %> : 스크립트릿, java 코드 사용
    - <%= %> : 출력식
    - <%! %> : java 함수 작성
    - <%-- --%> : 주석
 
* Model 1방식 : Model(Java) + View(JSP)
* Model 2방식 : Model(Java) + View(JSP) + Controller(Servlet)

* 동작방식
  - Client가 요청하면 요청을 받는 것이 Controller(Servlet)이다. 
  - Controller와 Model(java)이 연결되어있고 Model이 JDBC로 DB연동을 한다. 
  - Controller가 바로 Client에게 응답하지 않고 View인 JSP에게 요청을 의뢰(**RequestDispatcher**)한다.
  - JSP는 Controller가 Model을 통해 받은 Data를 가지고 만든 JSP를 Client에게 바로 주는 것이 아니라 Controller에게 응답한다.
  - Controller는 JSP가 보낸 결과를 Client에게 응답한다.
  - Controller와 JSP가 Data를 주고 받고 하는 것을 **Forward(Forwarding)** 라고 한다. 
  - Controller가 가진 Data를 JSP가 가져가는 것은 **객체 바인딩**이라고 한다. 객체를 특정 메모리에 연결시켰다는 의미이기 때문에 객체 바인딩이라고 한다. Controller는 setAttribute를 이용해 특정 메모리 공간에 Data를 넣어주고, 그 공간의 메모리를 JSP가 getAttribute를 이용해 가져간다. 
  
* MVC04
  - FrontController와 Controller역할의 Java 파일들로 분리해 구성하였다.
  - Controller역할을 하는 Java파일들을 POJO라고 한다.
  - 이전까지는 하나의 Controller에서 사용자의 요청을 받아 처리하는 역할까지 모두 하였지만 사용자의 요청을 받아 알맞은 일을 POJO에서 처리한다.
  - 또한 FrontController에서 어떤 요청을 받았는지 if-else문을 활용해 나누기보다는 HandlerMapping class를 만들어 어떤 요청을 하였는지 판단하도록 해 FrontController에서는 사용자의 요청만 받아오는 역할을 처리하도록 구현한다.
  - ViewResolver를 통해 jsp파일을의 실제 위치 주소를 POJO에서 직접 return 하지 않고, prefix와 subfix를 붙여 ViewResolver에서 return 하는 방식을 사용했기 때문에 파일의 경로가 바뀌거나 수정사항이 발생하면 유지보수가 편하도록 수정하였다.
  - MVC04까지는 JDBC를 이용해 구현, 이후 프로젝트는 MyBatis로 수정한다.
  - 현재 방식은 FrontController와 POJO들로 구성해 FrontController의 역할이 가벼워졌지만, 이 방법도 POJO들이 계속 증가할 수 있다는 단점이 있다.
  
* MVC05
  - MVC04까지는 JDBC를 이용해 DB를 연결하였는데 이것을 MyBatis로 변경한다.
  - JDBC의 문제점 : 유지보수가 어렵고, driver 정보, user, password 정보를 코드에 노출하고 있기 때문에 보안상의 문제가 존재한다. 또한 개발속도가 느리다는 단점이 있다.
  - MyBatis는 SQL Mapping Framework로서 Mapping하는 방식으로 사용하며, 기본 설정을 위해 3개의 파일이 필요하다.
    - (1) config.xml : 환경설정 파일로, Mapper.xml의 정보와 db.propeties의 정보 등을 저장한다.
    - (2) Mapper : SQL 쿼리들을 저장하는 xml 파일로 MemberDAO java 파일에서 id를 통해 사용한다.
    - (3) db.properties : driver, user, password, url 정보만 따로 저장해 사용한다.
    - 또한 MyBatis는 Connection POOL 방식으로 구동된다. JDBC의 경우에는 사용자가 요청할 때 Connection을 생성해 작동하는 방식이었다. MyBatis는 SqlSessionFactory에 SqlSession들을 미리 생성해두고 필요할 때 꺼내서 사용하는 방식으로 구현한다. 또한 직접 쿼리를 Java 파일에서 작성하지 않고 Mapper.xml에 저장한 쿼리를 id를 통해 불러다 사용하기 때문에 코드가 JDBC보다 훨씬 짧아진다.
 
