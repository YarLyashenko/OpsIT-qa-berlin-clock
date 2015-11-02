Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase the number of ways that I can read the time

Scenario: Midnight
When the time is 00:00:00
Then Berlin clock should be like this:
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario:  Second after midnight
When the time is 00:00:01
Then Berlin clock should be like this:
O
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: After midnight
When the time is 00:55:31
Then Berlin clock shoul be like this:
O
OOOO
OOOO
YYRYYRYYRYYR
OOOO

Scenario: Morning
When the time is 09:04:40
Then Berlin clock shoul be like this:
Y
ROOO
RRRR
OOOOOOOOOOO
RRRR

Scenario: Noon
When the time is 12:00:00
Then Berlin clock shoul be like this:
Y
RROO
RROO
OOOOOOOOOOO
OOOO

Scenario: Evening
When the time is 20:30:59
Then Berlin clock shoul be like this:
O
RRRR
OOOO
YYRYYROOOOO
OOOO

Scenario: Before Midnight
When the time is 23:59:59
Then Berlin clock shoul be like this:
O
RRRR
RRRR
YYRYYRYYRYYR
RRRR
