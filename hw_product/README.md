# 유저 관리 기능
## 1. 로그인 - 세션 사용
```
세션을 사용하여 유저 정보를 저장해주었음.
만약 로그인이 되어있지 않은 상태에서 [상품리스트], [상품등록] 메뉴를 누르게되면 alert가 뜨게 하였음.
```
![비로그인_메인](https://user-images.githubusercontent.com/41807132/138600241-466280f0-301a-4f34-b4ae-02a9fdc753d6.JPG)

```
alert 뜨는 화면
```

![비로그인시_메뉴클릭](https://user-images.githubusercontent.com/41807132/138600242-86718ecd-2070-4038-b155-24922a7a321b.JPG)

```
로그인이 완료되면 환영 인사와 함께 nav 바에 있는 [상품리스트], [상품등록]을 누를 수 있게 된다.
로그아웃 클릭 시 로그아웃이 되며 세션 또한 사라진다.
```

![로그인시_메인](https://user-images.githubusercontent.com/41807132/138600240-31462a7e-6be8-498d-a505-2cad4c5bad2f.JPG)

## 2. 상품 관리
```
상품등록 페이지에 가게되면 상품을 등록할 수 있다.
```

![상품등록페이지](https://user-images.githubusercontent.com/41807132/138600244-5395d7a1-6a44-4848-8442-2b4c37ef0a2a.JPG)

![상품등록중](https://user-images.githubusercontent.com/41807132/138600243-138bd2d8-6433-41de-9ff0-0e76efc1f62e.JPG)

```
register 버튼을 누르게 되면 상품 등록과 동시에 상품목록 화면으로 이동된다.
```
![상품등록후리스트로이동](https://user-images.githubusercontent.com/41807132/138600245-33979009-6dbb-404d-9f87-ff4c83cad997.JPG)

```
DB에도 잘 올라와 있는 모습
```

![등록후dv모습](https://user-images.githubusercontent.com/41807132/138600237-e322656a-c0ea-4445-bbde-1e5aae0cdff6.JPG)

```
상품 목록에서 수정을 누르게 되면 아래와 같은 수정화면으로 이동하고,
삭제를 누르면 상품이 삭제된다.
```

![수정화면](https://user-images.githubusercontent.com/41807132/138600246-4aa9a830-8878-4374-a719-b1df70273562.JPG)

