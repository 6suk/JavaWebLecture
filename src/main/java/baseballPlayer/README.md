# [โญMini Project] Sevlet - BaseballPlayer

- โ๐ปย **Recorded Date**ย : 2022๋ 12์ 11์ผ ์คํ 8:09
- ๐ฌย **Comment**ย : ์๋ธ๋ฆฟ์ ๋ฐฐ์ฐ๊ณ  ๋๋์ด! ์น์ฌ์ดํธ ๋ค์ด ์น์ฌ์ดํธ๋ฅผ ์ ์ํ  ์ ์๊ฒ ๋์๋ค! ๋๋ฌด๋๋ฌด ์ ๋๋ ๊ฑธ๐ ์ง๋๋ฒ ์ค์ต ๊ณผ์ ๋ก ์งํํ๋ ์ผ๊ตฌ์ ์ ์๋ฐ ํ๋ก๊ทธ๋จ์ ์ด์ฉํด์ ์น ์ฌ์ดํธ๋ฅผ ์ ์ํ๋ ๊ณผ์ ์๋ค! DAO์ DTO๋ ๊ธฐ์กด ๋ง๋ค์๋ ๋๋ก ์ฌ์ฉํ๊ณ , ์๋ธ๋ฆฟ์ ์ถ๊ฐํด DB์ ์ฐ๋ + ์น ์ฌ์ดํธ ์ ์๊น์ง ํด๋ณด์๋ค!
- [**2์ฐจ : Sevlet - BaseballPlayer ์น ์ฌ์ดํธ ์ฝ๋**](https://github.com/6suk/JavaWebLecture/tree/master/src/main/java/ch07_02)
- [1์ฐจ : JDBC - BaseballPlayer ์๋ฐ ์ฑ ์ฝ๋](https://github.com/6suk/JavaLecture/tree/master/src/mysql/baseballPlayer)
- [๋ธ์์์ ๋ณด๊ธฐ](https://www.notion.so/Mini-Project-Sevlet-BaseballPlayer-f6d714fa630d473e853af7f6f56bc0b4)

<br><br>

### โฝ ๊ณผ์  ๋ด์ฉ

1. ์ข์ํ๋ ํ๋ก์ผ๊ตฌ ๊ตฌ๋จ์ ์ ์๋ฅผ ๋ฑ๋กํ๋ ค๊ณ  ํ๋ค.
2. ๋ฑ๋กํ๋ ค๋ ์ ๋ณด๋ ์ ์๋ช, ๋ฐฑ๋๋ฒ, ํฌ์ง์, ์๋์์ผ, ํค(height)
3. primary key๋ ๋ฐฑ๋๋ฒ๋ก ํ๋ค.
4. ๊ฐ ํฌ์ง์(ํฌ์, ํฌ์, ๋ด์ผ์, ์ธ์ผ์) ๋ณ๋ก 3๋ช ์ด์์ ์ ์๋ฅผ ๋ฑ๋กํ๋ค.
5. **์ ์ ๋ชฉ๋ก**, **์ ์ ๋ฑ๋ก**, **์ ์์ ๋ณด ์์ **, **์ ์ ๋ฐฉ์ถ**ํ  ์ ์๋ App ๋ง๋ค๊ธฐ
6. +) ์ฌ๊ธฐ์ ๋๋ **์ ์ ์ฌ์๋จ**๋ ์ถ๊ฐํด๋ณด์๋ค!

<br><br>

## ๐ธ ์ฌ์ดํธ ๊ตฌ์กฐ

| no  | Next Page | name          | routing                 | method     | input                                      |
| --- | --------- | ------------- | ----------------------- | ---------- | ------------------------------------------ |
| 1   |           | ์ ์๋ชฉ๋ก      | /ch07/playerList        | GET        | num, name, position, bDay, Height          |
| 2   | 3         | ์ ์๋ฑ๋ก PAGE | /ch07_02/regPlayer.html | -          |                                            |
| 3   | 1         | ์ ์๋ฑ๋ก      | /ch07/regPlayer         | POST       | num, name, position, bDay, Height          |
| 4   | 1         | ์ ์๋ฐฉ์ถ      | /ch07/deletePlayer      | GET        | num                                        |
| 5   | 1         | ์ ์์์       | /ch07/updatePlayer      | GET + POST | num<br>option name, position, bDay, Height |
| 8   | 1         | ์ ์์ฌ์๋จ    | /ch07/rejoinPlayer      | GET + POST | num                                        |

<br><br>

## ๐ธ ์ ์ ๋ชฉ๋ก - HOME

- **์ ์ ๋ฆฌ์คํธ ์ถ๋ ฅ**
  - DB์ ์ ์ฅ๋ ์ผ๊ตฌ ์ ์ ๋ฆฌ์คํธ๋ GET ๋ฐฉ์์ผ๋ก ์ถ๋ ฅํ๋ค.
  - ๊ธฐ์กด์ DAO์ ์ ์ํด๋ `playerList()` ๋ฉ์๋๋ฅผ ํ์ฉ HTML๋ก ์ถ๋ ฅํ๋ค.
- **์ ์ ์ฌ์๋จ, ์ ์ ์์ , ๋ฐฉ์ถ**
  - ๋ฒํผ์ ๋๋ฅด๋ฉด ๊ฐ ๋งคํ๋ ๋ฃจํธ๋ก ์ด๋ํ๋ค.
  - **๋ฐฉ์ถ :** GET ๋ฐฉ์์ผ๋ก ๋ฐ์ `delete()` ๋ฉ์๋์ ์ ์ ๋ฐฑ๋๋ฒ๋ฅผ ๋๊ฒจ ์ฒ๋ฆฌํ๋ค.
    - DB์๋ `isDelete` ๋ผ๋ ํญ๋ชฉ `0`, `1`๋ก ์ ์์ ๋ฑ๋ก ์ฌ๋ถ๋ฅผ ๋๋ด๋ค.
    - ๋๋ฌธ์ ์ด๋ `delete()` ๋ฉ์๋๋ก ์ ์ก๋๋ SQL๋ฌธ์ `DELETE`๊ฐ ์๋ `UPDATE`์ด๋ค.

<img src = "../../../../img/1211_01.png">
<br><br>

## ๐ธ 2. ์ ์ ๋ฑ๋ก

<img src = "../../../../img/1211_02.png">

<br>

### โฝ ์ ์ ๋ฑ๋ก - ์ ํจ์ฑ ๊ฒ์ฌ

- **HTML**
  - DB **๋ชจ๋  ๊ฐ** == `NOTNULL`
    - input required ์์ฑ ์ถ๊ฐ
  - DB **name** type == `varchar(4)`
    - input maxlength 4 ๋ก ์ ํ

```html
<input type="number" name="bNum" placeholder="๋ฐฑ๋๋ฒ" required />
<input type="text" name="name" placeholder="์ ์ ์ด๋ฆ" maxlength="4" required />
<input type="date" name="bDay" placeholder="์๋์์ผ" required />
<input type="number" name="h" placeholder="ํค(์ ์ฅ)" max="250" required />
```

- **Servlet**
  - ๋ฐฑ๋๋ฒ == `Primary Key` : ์ค๋ณต๊ฐ์ด ๋ค์ด์ค์ง ์๋๋ก Servlet์ ์ ํจ์ฑ ๊ฒ์ฌ ์ถ๊ฐ

```java
/** ์ ํจ์ฑ ๊ฒ์ฌ */
if(dao.getPlayer(bNum).getNum() != 0) {
	response.sendRedirect("/ch07_02/regPlayer.html");
}else {
	name = request.getParameter("name");
	posi = request.getParameter("posi");
	bDay = request.getParameter("bDay");
	h = Integer.parseInt(request.getParameter("h"));
	p = new Player(bNum, name, posi, bDay, h);
	dao.setPlayer(p);
	response.sendRedirect("/ch07/playerList");
}
```

<br><br>

## ๐ธ 3. ์ ์ ์์ 

- **Get ๋ฐฉ์**์ผ๋ก ํด๋น ์ ์ ์์  ํ์ด์ง๋ก ์ด๋ํ๋ค.
  - `/ch07/updatePlayer?bNum=xxx`
- `key`๊ฐ์ธ ๋ฐฑ๋๋ฒ๋ฅผ ์ ์ธํ **๋๋จธ์ง ์์ฑ๋ค์ ์์  ๊ฐ๋ฅ**ํ๋ค.
- ์ฒซ ํ๋ฉด์ **๊ธฐ์กด ์ ๋ณด๊ฐ input value์ ๊ธฐ์**๋์ด ์๋ค.
- โ์ ์ ์์ โ ๋ฒํผ์ ๋๋ฅด๋ฉด ์๋ก ๊ธฐ์๋(๋๋ ๊ธฐ์กด ์ ๋ณด) `value`๋ฅผ **Post ํ์**์ผ๋ก ๋ฐ๋๋ค.
- DAO์ `update()` ๋ฉ์๋๋ก **sql๋ฌธ์ ์ ์ก**ํ๋ค.
- ์์ ์ด ์ ์ฉ๋ **ํ ํ๋ฉด (์ ์ ๋ฆฌ์คํธ)์ผ๋ก ์ด๋**ํ๋ค.

<img src = "../../../../img/1211_03.png">

<br><br>

## ๐ธ 4. ์ ์ ์ฌ์๋จ

- **GET**
  - ํ ํ๋ฉด์์ **์ ์ ์ฌ์๋จ** ๋ฒํผ์ ๋๋ฅด๋ฉด ๊ฐ์ฅ ๋จผ์  โ**๋ฐฉ์ถ ์ ์ ๋ฆฌ์คํธ**โ๊ฐ ์ถ๋ ฅ๋๋ค.
  - ๊ฐ ๋ฆฌ์คํธ ๋ณ๋ก input hidden ์์ฑ์ ์ถ๊ฐํด value๋ ์ ์์ ๋ฐฑ๋๋ฒ๋ก ํ๋ค.
  - โ์ฌ์๋จโ ๋ฒํผ์ ์์ฑ์ submit์ผ๋ก ์ฃผ๊ณ , **ํด๋น ์ ์์ ๋ฐฑ๋๋ฒ๋ฅผ Post๋ฐฉ์**์ผ๋ก ๋ณด๋ธ๋ค.
- **POST**
  - ์ ๋ฌ๋ฐ์ ์ ์์ ๋ฐฑ๋๋ฒ๋ฅผ ์ธ์๋ก ๋ฐ์ DAO `์ฌ์๋จ ๋ฉ์๋`๋ฅผ ์คํ์ํจ๋ค.
  - ์ด๋ ์ ์ก๋๋ SQL๋ฌธ์ ๊ธฐ์กด isDelete์ ๊ฐ์ `1`์์ `0`์ผ๋ก `UPDATE`ํ๋ค.
  - ์ฌ์๋จ์ด ์ ์ฉ๋ **ํ ํ๋ฉด (์ ์ ๋ฆฌ์คํธ)์ผ๋ก ์ด๋**ํ๋ค.

<img src = "../../../../img/1211_04.png">

<br><br><br><br>
