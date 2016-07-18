Feature: To be able to see reports and graphs influence
  how / how much I drive and whether to upgrade my estimated
  miles on lease arrangement.

  Scenario: Viewing miles per gallon graph
    Given the following recorded fill ups
      | date       | mileage | quantity | cost  |
      | 2016-06-13 | 24      | 37       | 0     |
      | 2016-06-17 | 426     | 33.61    | 37.95 |
      | 2016-06-20 | 683     | 22.12    | 24.97 |
      | 2016-06-24 | 1134    | 36.69    | 41.42 |
      | 2016-06-30 | 1577    | 36.95    | 40.61 |
      | 2016-07-06 | 2063    | 39.71    | 44.83 |
      | 2016-07-09 | 2386    | 25.58    | 28.88 |
      | 2016-07-12 | 2783    | 32.72    | 36.94 |
    Then I will see a graph presenting