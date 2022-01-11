## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

4. 구현 기능 목록

- 1부터 9까지 서로 다른 수로 이루어진 3자리수 만들기
    - 3개의 숫자가 모두 1부터 9사이에 있는지 확인하기
        - 숫자가 1부터 9사이에 있는지 확인하기
    - 3개의 숫자가 서로 중복되지 않는지 확인하기
- 플레이어 숫자에 대한 결과 만들기
    - 같은 수가 같은 자리에 있으면 스트라이크
    - 같은 수가 다른 자리에 있으면 볼
    - 같은 수가 전혀 없으며 포볼

- 사용자로부터 숫자 입력 받기

- 결과 출력하기
- 안내멘트 출력하기

- 게임 흐름 제어하기
- 게임 종료 또는 재시작하기
    - 정답 숫자와 플레이어의 숫자가 모두 같은지 확인하기

5. 객체 설계

- AnswerNumbers : 정답 숫자
- PlayerNumbers : 플레이어 숫자
- Results : 게임 결과
    - ResultType : 결과 종류
- Referee : 플레이어 숫자의 결과를 판정
- InputView : 사용자 입력 받기
- OutputView : 화면 출력하기
    - OutputType : 출력 종류
- Application : 게임의 전체적인 진행
- ValidationUtils : 숫자가 유효한지 판단
