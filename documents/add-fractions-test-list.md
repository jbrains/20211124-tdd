# Add Fractions

### Backwards compatible with integers

- 3 + 4 = 7
- 4 + -9 = -5
- 0 + 0 = 0     # simplest/smallest test. "kernel"
- 0 + 3 = 3
- -2 + 0 = -2
- integer overflow

### Non-integer fractions

- 1/8 + 3/8 = 1/2     # result needs to be reduced
- 1/2 + 3/2 = 2       # result is an integer
- 1 + 3/2 = 5/2       # result is an improper fraction
- 1/3 + 1/3 = 2/3     # result is simple; denominators are the same
- 1/2 + 1/3 = 5/6     # result is simple; denominators are not the same
- -1/2 + 1/3 = -1/6   # some fractions are negative

## Create Fractions

- 8/0   # zero denominator: throw exception (Maybe<Fraction>?, NaN/undefined?)
- integer overflow
 
## Fractions Equal

By convention, when the fraction is negative, the negative quantity is always the _numerator_.
- -1/2 = 1/-2
- -3/-7 = 3/7
- 3/7 = 21/49 = -12/-48 ...
