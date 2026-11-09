# Journal

## Phase 1

I created custom checked exceptions and a SpellCaster class that randomly succeeds or throws an exception. I learned that checked exceptions must be handled or declared, while unchecked exceptions do not require this.

## Phase 2

I created a list of five spells and used a loop to cast each one. I learned that placing try-catch inside the loop allows the program to continue even if a spell fails. If try-catch surrounds the entire loop, an exception can stop the remaining spells from being attempted.

## Phase 3

I added file writing to record every spell attempt in spell_log.txt. I used try-with-resources to automatically close the file after writing, even if an error occurs. This is easier and safer than manually closing the file in a finally block.
