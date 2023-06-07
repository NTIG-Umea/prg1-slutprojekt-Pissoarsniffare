
# MittCV

Samuel Viglundsson 2023-06-02.

## Inledning

Syftet med arbetet var att skapa en spelbar version av Breakout och utforska grundläggande koncept inom spelprogrammering. Jag använde mig av Java och Swing-biblioteket för att implementera spelets logik, grafik och användarinteraktion.

## Bakgrund

Arbetet innehöll flera olika delar som var viktiga för att kunna skapa en fungerande breakout.

1. Skapande av spelplan: En spelplan med fast storlek (600x400) skapades med hjälp av en int. Spelplanen användes för att rita ut olika spelobjekt, inklusive paddeln, bollen och brickorna.
2. Rita ut paddel, boll och bricks: Jag ritade ut bollen, paddeln och brickorna med hjälp av public void draw. 
3. Röra paddeln: Jag änvände mig av en Keylistener för att kontrollera rörelsen av paddeln. Genom att ändra värdena för paddelVX kunde paddeln röra sig åt antingen höger eller vänster beroende på vilken knapp man tryckte.
4. Röra bollen: Jag gjorde så att när jag rörde paddeln började bollen röra på sig. Jag använde mig av public void update för att få bollen att fortsätta röra på sig. Ytterligare logik implementerades också för att hantera gränserna på spelplanen och kollisioner med objekt som paddeln och brickorna.
## Positiva erfarenheter

- Jag har lärt mig mycket mera programmering i Java som kanske kommer vara användbart i framtiden
- Spelets grundläggande logik fungerar korrekt, inklusive rörelsen för paddeln och bollen.
- Jag överlevde.

## Negativa erfarenheter


- När bollen studsade på sidan av brickorna så studsade den inte riktigt som förväntat.
- Jag tänkte lägga till så att om paddeln missar bollen skulle spelet restarta, men jag hade inte tid med det. Jag tänkte också lägga till mer svårighetsgrader men det hann jag inte med heller.
- Jag hade kursprov i fysik, så istället för att programmera pluggade jag fysik istället.



## Sammanfattning

Jag skapade en spelbar version av Breakout i Java med hjälp av Swing-biblioteket. Genom att implementera olika delar, inklusive skapande av spelplan, ritning av paddeln, bollen och brickorna, samt hantering av rörelsen för paddeln och bollen, uppnåddes målet att skapa en fungerande Breakout.
Jag lärde mig mycket under detta projekt och lyckades till och med skapa en fungerande version av breakout. Det fannas dock också negativa erfarenheter som att bollen inte kunde studsa på sidorna av brickorna. Jag hade också ganksa lite tid så jag hann inte lägga till allt jag ville ha med.