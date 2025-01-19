# 유애나 모의고사

</br>

## 프로젝트 소개
-  가수 '아이유'와 관련된 퀴즈들을 풀수 있는 간단한 퀴즈앱입니다.
-  이 프로젝트는 Kotlin으로 개발된 간단한 퀴즈 앱입니다.
-  사용자는 다양한 질문에 답하고, 최종 점수를 확인할 수 있습니다.
-  Google AdMob을 활용해 광고 수익화를 구현했습니다.


## 주요 기능
- 다중 선택 퀴즈 기능
- ViewBinding을 사용한 간단하고 효율적인 UI 연결
- 광고 삽입 (AdMob)으로 수익화
- 점수 기록 저장 및 표시
- **Jetpack**을 활용한 현대적 Android 개발 방식

## 기술 스택
- **언어**: Kotlin
- **플랫폼**: Android
- **Min SDK**: 23 (Android 6.0)
- **Compile SDK**: 32 (Android 12L)
- **Target SDK**: 32 (Android 12L)
- **빌드 시스템**: Gradle
- **뷰 구성**: ViewBinding 활성화

## 사용된 라이브러리
### Android Jetpack
- `androidx.core:core-ktx`: Kotlin 확장 라이브러리
- `androidx.appcompat:appcompat`: 호환성 지원 라이브러리
- `androidx.constraintlayout:constraintlayout`: ConstraintLayout 기반 UI 구성
- `androidx.cardview:cardview`: 카드 UI 컴포넌트
- `androidx.recyclerview:recyclerview`: RecyclerView를 사용한 리스트 UI
- `androidx.recyclerview:recyclerview-selection`: RecyclerView 항목 선택 관리
- `com.google.android.material:material`: Material Design UI 구성 요소

### 광고 플랫폼
- **Google AdMob**:
  - `com.google.android.gms:play-services-ads:20.5.0`: 광고 로드 및 표시

### 테스트
- `junit:junit`: 단위 테스트
- `androidx.test.ext:junit`: JUnit 확장 테스트
- `androidx.test.espresso:espresso-core`: UI 자동화 테스트

## Google AdMob 설정
이 앱에서는 Google AdMob을 사용하여 광고를 표시합니다.  
### 주요 설정
1. **의존성 추가**:
   ```gradle
   implementation 'com.google.android.gms:play-services-ads:20.5.0'
