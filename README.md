아프리카TV Android 사전과제입니다.

프로젝트는 `app - domain - data` 모듈 3개로 이루어져 있습니다.

Clean Architecture를 참고해서 `UI - ViewModel - UseCase - Repository - DataSource` 로 구성되어 있습니다.

UI는 방송 목록을 보여주는 Activity와 선택한 카테고리에 따라 생방송 목록을 보여주는 Fragment, 선택한 방송의 자세한 내용을 보여주는 Activity로 이루어져
있습니다.

API의 Key는 `local.properties`의 `key.afreeca`에 저장해서 사용했습니다.

## Android SDK
- minSDK - 23
- targetSDK - 31

## 사용 라이브러리
- Jetpack paging3, ViewModel
- ViewPager2
- Hilt
- Glide
- Retrofit

## 실행 화면
- 생방송 목록
<img src="https://github.com/choius323/AfreecaTest/blob/master/image/broad_list_drag.gif?raw=true" width="300"/>

- 카테고리 변경
<img src="https://github.com/choius323/AfreecaTest/blob/master/image/broad_detail.gif?raw=true" width="300"/>

- 생방송 상세 정보
<img src="https://github.com/choius323/AfreecaTest/blob/master/image/broad_detail.gif?raw=true" width="300"/>
                

<a href="https://www.flaticon.com/free-icons/warning" title="warning icons">Warning icons created by
Freepik - Flaticon</a>
