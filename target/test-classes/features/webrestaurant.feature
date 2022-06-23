Feature: Test search feature
  @smoke
  Scenario: Test table
  Given users are on  the homepage
  When user search "stainless work table"
  Then user should see "table" in every title



#hello




  #1. https://www.webstaurantstore.com/
  #2. search for "stainless work table"
  #3. check the search result ensuring every
  #   product has the word "Table" in its title
  #4. add  the last of found items to cart
  #5. empty cart