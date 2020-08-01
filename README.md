# addresses_provider
This is an address provider which returns json string of address  with street names and numbers.

#Libraries

1.  For JSONObject,  gson-2.8.0 is added
2.  For Test cases,  junit-4.13 is added

#Approach

Programing Language: Kotlin

Based on the analysis of address line, there are mainly four different types of inputs.
So in the current implementation, address line is parsed with four different regex
1. When first word is digit
2. When any of the last two words are digit and 
3. Digits after 'No'
3. When last word is digit

