# ✅ Gomachijan 두 구현 성능 비교

## 📌 요약 비교표

| 항목        | `Gomachijan` (첫 번째)      | `GomachijanBookSolution` (두 번째) |
| --------- | ------------------------ | ------------------------------- |
| 연산자 조합 생성 | 루프 기반 (flat)             | 재귀 기반 (deep)                    |
| 재귀 깊이     | 낮음 (`calcEverySign`만 사용) | 깊음 (`rec` 호출 깊이 8)              |
| 메모리 사용    | 더 많은 Heap 메모리 사용         | 메모리 효율적 (필요한 조합만 처리)            |
| 스택 사용     | 적음                       | 많음                              |
| 속도        | 전체 조합을 모두 계산 → 느림        | 가지치기로 빠르게 스킵 가능 → 빠름            |
| 결과 수집     | `Set` 사용 → 중복 제거         | `List` 사용 → 단순 수집               |

---

## 🔍 세부 분석

### 1. 연산자 조합 생성 방식

* **`Gomachijan`**
  → `calcEverySign()`에서 \*\*모든 조합 (5^8 = 390,625개)\*\*을 생성 후 계산
  → 불필요한 연산 포함되어 **비효율적**

* **`GomachijanBookSolution`**
  → `rec()` 함수에서 **생성과 동시에 계산 및 조건 판단**
  → 조건 불충족 시 빠르게 재귀 종료 (**가지치기 가능**)

✅ **성능상 이점**: `BookSolution` 쪽이 훨씬 효율적

---

### 2. 메모리 사용 비교

* **`Gomachijan`**

    * Stack 사용은 적지만
    * 모든 조합을 저장하므로 **Heap 메모리 소모 큼**

* **`BookSolution`**

    * Stack 사용은 많지만
    * 필요한 조합만 처리하므로 **Heap 메모리 적음**

✅ **메모리 효율성**: `BookSolution` 우세

---

### 3. 실행 속도

* **`Gomachijan`**

    * 무조건 39만 개 계산 → 항상 느림

* **`BookSolution`**

    * 조건 불만족 시 빠르게 return
    * 특히 목표값이 큰 경우 효과 큼

✅ **속도**: `BookSolution` 빠름

---

## 🏁 결론

| 항목                 | 추천 코드                    |
| ------------------ | ------------------------ |
| **속도 빠름**          | `GomachijanBookSolution` |
| **메모리 적게 사용 (총합)** | `GomachijanBookSolution` |
| **스택 적게 사용**       | `Gomachijan`             |
| **코드 유지보수 쉬움**     | `Gomachijan`             |
| **대규모 연산 최적화**     | `GomachijanBookSolution` |

---

## 💡 제안: 성능 + 가독성 모두 잡기

`GomachijanBookSolution`의 재귀 구조에 다음을 적용해보세요:

* `Set<String>`으로 중복 제거
* 중간 결과 기반 **가지치기 추가**
* `Gomachijan` 방식의 연산자 처리 로직 개선

필요하다면 최적화 버전 구현 도와드릴게요! 🙌

---