# Testowanie aplikacji JAVA 2017-2018
## Projekt 1 (JUnit, narzędzie Hamcrest oraz MAVEN) 
###Hotel Reservation System
Paweł Jadanowski

-----------------------
### REGUŁY GRY

1. Wybieramy **jedno** z poniższych zadań. Zadania różnią się poziomem trudności i są inaczej punkto-
wane. 

2. Każdy projekt ma być wykonany przy użyciu narzędzia Maven! Projekt **nie powinien zawierać pliku jar oraz folderu
target**.

3. Przesyłanie projektu będzie odbywało się przy pomocy utworzenia Issue w swoim repozytorium. Utworzenie Issue wiąże się z oddanym projektem. Wszelkie zmiany po Issue będą obcinane.

**TERMIN: 09.04.2018**

- **Spóźnienia** z terminem będą wiązały się z **mniejszą ilością punktów**.
- **Maksymalny deadline** to **13.04.2018** i wtedy obowiązuje **50%** punktów z projektu. A więc dzień zwłoki oznacza obniżenie progu o **10%**. Po tym terminie projekty liczone są na **0%**!
- Projekt, w którym nie będzie wykonywało się polecenie **mvn test** będzie liczony na **0%**!
- Ponadto pod ocenę będzie brany styl projektu: jak zapisane są testy i jak sprawdzane są asercje.
- Testy powinny wykorzystywać wiele różnych asercji (a nie tylko assertEquals)!
- Ponadto po sprawdzeniu projektu należy go obronić: będą to krótkie pytania i ewentualne drobne
zmiany w kodzie podane przez prowadzącego!

-------------------------

**PROJEKT 6** (20 pkt)

Napiszmy program, który będzie realizował prostą wersję systemu rezerwacji (do wyboru: książek, hoteli, restauracji itd.). 

Program ma następujące wymagania: 
- Załadować bazę danych z pliku tekstowego do systemu.
- Ma zwracać listę zarezerwowanych rzeczy dla danego użytkownika (warto skorzystać tutaj z HashTable).
- Ma unikać podwójnego rezerwowania rzeczy w tym samym dniu i godzinie.
- Ma być odporny na wszelkie nieprawidłowe argumenty. 
- Powinien rezerwować o pełnych godzinach lub np: 10.30, 11.30 itd. 
- Powinien zapisywać identyfikator zamówienia (np. adres email).
- Powinien generować potwierdzenia zamówienia (zapis do pliku lub unikalny kod).
- Powinien obsługiwać wszelkie wyjątki (rezerwacja w złym dniu, o godzinach nieczynnej restauracji itd.) 

Plik tekstowy z bazą danych może być dowolnego formatu, ale powinien zawierać nazwę miejsca, godziny otwarcia, dni oraz godziny wolne do rezerwacji, opis dodatkowy. 

Pod ocenę będą brane pod uwagę następujące elementy:
- (1 pkt) Kompilacja i uruchomienie bezbłędne projektu.
- (5 pkt) Uwzględnienie powyższych wymagań.
- (6 pkt) Przypadki testowe.
- (1 pkt) Użycie różnych asercji.
- (2 pkt) Uwzględnienie wyjątków.
- (1 pkt) Zastosowanie biblioteki Hamcrest.
- (1 pkt) Pokrycie kodu.
- (1 pkt) Styl kodu.
- (1 pkt) Zastosowanie metodyki TDD.
- (1 pkt) Zastosowanie testów parametrycznych.

Ponadto dodatkowo pod uwagę będą brane następujące elementy: 

- (1 pkt) Użycie biblioteki AssertJ.
- (1 pkt) Skonfigurowanie TravisCI do automatycznego budowania projektu.
- (1 pkt) Zastosowanie testów parametrycznych przy użyciu plików testowych.
- (1 pkt) Zastosowanie JAVA 8 lub wyżej.
- (2 pkt) Użycie planszy dowolnego wymiaru.
- (2 pkt) Użycie innych technologii nie pokazywanych na zajęciach.

Ponadto pod ocenę jest brane również: (Brak tych elementów: -1 pkt za
podpunkt od obowiązkowej punktacji zadania!)
- Historia projektu w repozytorium.
- Ocena opisu commitów 
- Stan repozytorium (żeby nie był śmietnikiem!!!)
