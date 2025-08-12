# GitHub Repositories API

### 📜 Opis projektu
Aplikacja w języku Java, zbudowana na platformie **Spring Boot**, która udostępnia endpoint do pobierania listy repozytoriów danego użytkownika z serwisu GitHub. Aplikacja spełnia następujące kryteria:

- ✅ **Wyświetla listę publicznych repozytoriów, które nie są forkami.**
- Dla każdego repozytorium zwraca:
    - Nazwę repozytorium.
    - Nazwę właściciela.
    - Dla każdej gałęzi (`branch`) jej nazwę i SHA ostatniego commita.
- 🚫 W przypadku, gdy użytkownik nie istnieje, zwraca odpowiedź HTTP **404** w niestandardowym formacie JSON.

---

### 🚀 Wymagania systemowe
- **Java 17+**
- **Gradle**

---

### ⚙️ Uruchomienie aplikacji
1.  Sklonuj repozytorium:
    `git clone [URL_DO_TWOJEGO_REPOSITORIUM]`
2.  Przejdź do katalogu projektu:
    `cd github-repos-api`
3.  Zbuduj projekt za pomocą Gradle:
    `./gradlew build`
4.  Uruchom aplikację:
    `java -jar build/libs/github-repos-api-0.0.1-SNAPSHOT.jar`

Aplikacja będzie dostępna pod adresem `http://localhost:8080`.

---

### 📋 Użycie API

#### Endpoint
`GET /repositories/{username}`

#### Przykłady

**1. Sukces (użytkownik istnieje):**
`GET /repositories/octocat`

Odpowiedź:
```json
[
  {
    "repositoryName": "Hello-World",
    "ownerLogin": "octocat",
    "branches": [
      {
        "name": "master",
        "commit": {
          "sha": "7fd1a60b01f91b314f599557ed3919e8638363"
        }
      }
    ]
  },
  // ... inne repozytoria
]