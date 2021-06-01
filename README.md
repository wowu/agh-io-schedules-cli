# Schedules - aplikacja konsolowa
Projekt na zajęcia Inżynieria Oprogramowania 2020/2021 na Akademii Górniczo-Hutniczej w Krakowie.
# Spis treści
- [Cel aplikacji konsolowej](#cel-aplikacji-konsolowej)
- [Funkcjonalności](#funkcjonalności)
- [Format wejściowy](#format-wejściowy)
- [Przykładowe harmonogramy](#przykładowe-harmonogramy)
- [Implementacja](#implementacja)


# Cel aplikacji konsolowej
Głównym zadaniem aplikacji konsolowej jest przedstawienie klientowi sposobu oraz możliwości działania
stworzonego algorytmu do parsowania oraz wyszukiwania konfliktów w harmonogramach. Aplikacja konsolowa
nie jest zintegrowana z aplikacją webową, która jest gotowym produktem, lecz jedynie bazą implementacyjną
do wcześniej wspomnianej aplikacji webowej.
# Funkcjonalności
Aplikacja konsolowa na wejściu przyjmuje listę argumentów - ścieżki do plików w formacie .xls lub .xlsx 
zawierających harmonogramy, które powinny zostać sprawdzone pod kątem możliwych konfliktów. Jako parametr
można również podać folder - zostaną w nich rekursywnie odnalezione wszystkie pliki o podanym rozszerzeniu.
Aplikacja na wyjściu podaje wszystkie odnalezione konflikty między harmonogramami (lub informację o ich braku).
Jako konflikt przyjęliśmy sytuację, w której w tym samym czasie wykładowca ma więcej niż jedno wydarzenie,
grupa laboratoryjna uczestniczy w więcej niż jednym wydarzeniu lub sala jest zajęta przez więcej niż jedno wydarzenie.
# Format wejściowy
Harmonogramy wejściowe muszą spełniać konkretne założenia. Przyjęliśmy, że tylko takie harmonogramy zostaną 
zaakceptowane przez program dzięki czemu zawsze jesteśmy w stanie przewidzieć zachowanie programu. Format wejściowy
widoczny jest w przykładowych harmonogramach.
# Przykładowe harmonogramy
[1. Harmonogram bez wewnętrznych konfliktów](1_schedule_all_remote_no_conflicts.xlsx)  
[2. Harmonogram z wewnętrznymi konfliktami](5_schedule_all_university_with_multiple_conflicts.xlsx)  
[3. Harmonogram bez wewnętrznych konfliktów, lecz z konfliktami z harmonogramem 1](7_schedule_all_university_with_no_conflicts_with_1_but_with_6.xlsx)
# Implementacja
Aplikacja konsolowa została napisana w języku Java (wersja JDK 11).
