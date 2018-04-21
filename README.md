# eStore (Spring-Boot Project)

## Apache Tiles

### Apache Tiles는 왜 쓸 까?
 1. Tiles 프레임 워크를 사용하여 웹 사이트의 템플릿을 디자인 할 수 있다.
 2. 레이아웃 변경 요구 사항이 있으면 한 페이지에서 레이아웃을 변경해야 한다. 

### Apache Tiles는 무엇일까?
 1. 무료 오픈 소스 템플릿 프레임 워크
 2. 복잡한 웹 사이트에서 MVC 패턴과 함께 작업하는 것이 가장 쉽고 적절한 방법
 3. 템플릿을 이용하므로 웹 사이트에 일관된 느낌을 줄 수 있음

### 필요한 것
 1. Template 정의  (layout.jsp 파일 정의)
 2. 각각의 요소에 해당하는 Attribute 정의
 3. definition 정의  
  (Controller에서 return 하면 view의 name을 원래 return 했지만 그것에 대한 정의를 servlet-context.xml에서 지우고 apache tiles를 새로 정의 했으므로 이 definitio으로 mapping 되어 적절한 웹 페이지를 실행시켜 준다.)

### 사용법
 1. pom.xml에 apache tiles (라이브러리 다운)
 2. servlet-context.xml에서 원래 매핑해주던 bean을 지우고 TilesViewResolver, (2) TilesConfigurer 2가지 beans 선언
 3. Define page 선언 (layout.jsp)
 4. Tiles definition .xml 파일 생성
 5. 각각의 Attribute 생성 ex) header, footer, navigation
<br />

## CRUD

### 정의
 1. Create
 2. Read
 3. Updqte
 4. Delete
 
### 흐름
 1. form action or click href
 2. controller 
 3. service -> dao -> get model
 4. return view page name 
 
### 사용 법
 1. 각 흐름에 해당하는 부분을 만들어주면 된다.
<br />

## Validator

### 사용 법
 1. pom.xml에 hibernate.validator (라이브러리 다운)
 2. Controller의 인자에 해당 모델에 @Valid Annotation 추가 결과를 받을 BindingResult 추가 
   ex) (@Valid Product product, BindingResult result)
 3. Controller에서 result에 error가 있는지 체크함
 4. 검증 될 해당 모델에 조건에 따른 Annotation 추가
   ex) @NotEmpty(message="The product name must not be null")
 5. view page에서 error를 리턴 했을 경우를 추가
   ex) <sf:errors path="price" cssStyle="color:red" /> 
<br />

## Security

### 사용 법
 1. pom.xml에서 security-config, security-web, security-core (라이브러리 다운)
 2. security-context.xml 추가 (web.xml에서 contextConfigureLocation param으로 넣어줘야 함)
 3. web.xml에 security filter 추가
