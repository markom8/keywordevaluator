**What assumptions did you make?**
The assignment as I understood it is to find a statistically accurate value that a keyword will be searched by Amazon customers.
So in realitty any product that starts with a whole keyword as a prefix is a candidate for what a user was searching for.
   
**How does your algorithm work?**
My algoritm consists of several steps.

1. Step one is getting all responses as a list from Amazon completion api from asked keyword where each request to a completion api is for a keyword typed letter by letter.
So for example if keyword=cool i would generate a list of 4 responses where for each response in coresponding  request keyword would be c, co, coo and cool.

2. Step two is getting all suggestions from responses got from the Amazon api in a format that is customised for further processing.

3. Step three is structure all suggestions gotten from all requests in a map where a key would be a suggestion and a value number of appearances in responses.     

4. Step four is to do a simple calculation in order to get a statistical value.
Let me explain a bit the math behind this algoritm so the calculattion would be clear.
As a response for each request I get 10 suggestions from amazon that are the highest searched by their users.
So the probability that I would with each request find a suggestion that I was looking for is a simple count in the response suggestions devided by 10.
By using Bayes theorem( https://en.wikipedia.org/wiki/Bayes%27_theorem ) lets say that we are looking for keyword=car

A - is a event that keyword was found
H1 - is the event that we typed one letter (in example c) 
H2 - is the event that we typed two letters 
H3 - is the event that we typed all three letters

P(A|H1) = 0 
P(A|H2) = 0.3
P(A|H3) = 1
P(H1) = P(H2) = P(H3) = 1/3

P(A) = P(A|H1) * P(H1) + P(A|H2) * P(H2) + P(A|H3) * P(H3) = 0 * 1/3 +  0.3 * 1/3 + 1 * 1/3 = 0.43333333333

So this could be calculated a bit differently as I explained that for each request we get 10 responses that are candidates for keyword.
As I made a map that contains all suggested keywords ans their occurances we can simply filter this map for suggestions that start with the keyword and sum their occurances.
With this sum calculated we just need to devide it by the number of words in keyword and the percentage is calculated. :-)
 
**Do you think the (*hint) that we gave you earlier is correct and if so - why?**
Yep it gave me the idea of using Bayes theorem.
 
**How precise do you think your outcome is and why?**
