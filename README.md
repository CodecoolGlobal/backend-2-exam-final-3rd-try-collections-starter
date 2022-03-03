# Tudományos cikk gyűjtemény

## Feladatleírás

Készítsd el az `Article` osztályt. Ennek mezői: a szerző - `author`, címe - `title`, írás éve - `year`.

Készítsd el a `ScienceJournal` osztályt. Minden folyóiratnak van egy neve (`name`) és a cikkek rendezett halmaza!
Konstruktorában csak a nevét kapja meg.

Készítsünk ezekhez egy `add` metódust, amivel cikket lehet az újsághoz adni!

Készíts egy metódust: `size()` ami visszaadja a benne tárolt cikkek számát.

A rendezés elve a cikkek írásának éve legyen. Ezen belül a szerzők nevei szerint legyenek ABC sorrend-ben
felsorolva. Az azonos évben, azonos szerzőtől szereplő cikkek pedig a címük szerint legyenek sorrendben.

Készíts egy metódust `findByAuthor`, amiben egy szerző összes cikkét visszaadod egy listában!

Készíts egy metódust `findByAuthorAndYear`, amiben egy szerző adott évben megjelenő összes cikkét visszaadod egy listában!

Készíts egy metódust `findByAuthorLike`, amiben a cikk címének részlete alapján lehet keresni, azaz paraméterül kap egy szöveget és ha
valamelyik cikk címében megtalálható a szöveg, akkor visszaadja a cikket!