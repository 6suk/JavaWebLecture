# Customer

> 서블릿을 이용한 웹 구현 첫 실습

<br><br>

### ◽ 구현 기능

| no  | list       | routing                     | file name             | method | input     | Next Page |
| --- | ---------- | --------------------------- | --------------------- | ------ | --------- | --------- |
| 1   | 회원리스트 | /ch07/customerList          | CustomerServlet.java  | GET    |           |           |
| 2   | 회원가입   | /ch07/registerCustomer.html | registerCustomer.html |        |           |           |
| 3   | 회원가입   | /ch07/registerCustomer      | CustomerInsert.java   | POST   | uid, name | 1         |
| 4   | 회원탈퇴   | /ch07/deleteCustomer        | CustomerDelete.java   | GET    | uid       | 1         |
| 5   | 회원수정1  | /ch07/updateCustomer        | CustomerUpdate.java   | GET    | uid       | 6         |
| 6   | 회원수정2  | /ch07/updateCustomer        | CustomerUpdate.java   | POST   | uid, name | 1         |

<br>

### ◽ 회원 리스트 페이지

- 회원가입, 수정, 삭제

<img src = "../../../../img/1209_01.png">

<br><br>

### ◽ 회원 가입 페이지

- registerCustomer.html
  - maxlength, minlength를 이용해 글자수 유효성 검사
- registerCustomer.java
  - 중복 ID 유효성 검사

<img src = "../../../../img/1209_02.png">

<br><br>

### ◽ 회원 수정 페이지

- 아이디와 가입일자 `disabled`를 이용해 변경할 수 없도록 설정
- `disabled`를 이용하면 value가 전송되지 않기 때문에 `input hidden`을 통해 전송

<img src = "../../../../img/1209_03.png">

<br><br>
<br><br>
