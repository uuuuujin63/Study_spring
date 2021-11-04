## SpringBoot, mybatis 사용

## 1. 유저관리

## 메인페이지 - 비로그인 시
![image](https://user-images.githubusercontent.com/41807132/140332198-061b30e3-6944-4f0d-8be3-feb25fd1ed97.png)

## 메인페이지 - 로그인 시
```
로그아웃 클릭 시, 로그아웃 되며, 세션에 있던 유저정보도 사라진다.
```
![image](https://user-images.githubusercontent.com/41807132/140332382-e331455f-f6ea-4070-8d7f-7b90860eb494.png)

## 2. 상품관리
## nav 바
```
UJIN'S PRODUCT 클릭 시, 메인화면으로 이동
상품리스트 클릭 시, 상품 리스트 화면으로 이동
상품등록 클릭 시, 상품 등록하는 화면으로 이동
```
![image](https://user-images.githubusercontent.com/41807132/140332579-4dfc3ae8-7bdd-42ba-836f-47e714a2b905.png)

```
로그인을 하지 않은 경우 클릭하게 되면 로그인 후 이용할 수 있다는 알람창이 뜬다.
```
![image](https://user-images.githubusercontent.com/41807132/140332707-82d01f4b-fcde-4422-817f-bcbf3ebabf55.png)

## 상품리스트 페이지
```
수정, 삭제 버튼을 통해 수정 및 삭제가 가능하다.
```
![image](https://user-images.githubusercontent.com/41807132/140332904-e38a00bd-4170-4407-b9d3-be4e46a7d7b5.png)

## 상품리스트 페이지 - 상품 수정 페이지
```
모든 INPUT 폼 입력 후, MODIFY 버튼을 누르면 DB가 UPDATE 되고, 상품리스트 페이지로 이동한다.
```
![image](https://user-images.githubusercontent.com/41807132/140333142-e27fe999-a007-4eeb-8093-80cd0e66fb96.png)

## 상품 등록 페이지
```
상품과 함께 파일 등록도 가능하다.
CANCEL 버튼 클릭 시, 메인페이지로 돌아간다.
```
![image](https://user-images.githubusercontent.com/41807132/140333327-773cff5e-26cb-4982-b237-c31546004a35.png)



## 보완할 점
```
  모든 유저가 상품목록을 수정 및 삭제가 가능하다.
  파일 다운로드가 되지 않는다.
```
  

