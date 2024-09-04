from forex_python.converter import CurrencyCodes, CurrencyRates, RatesNotAvailableError

def run():
    try:
        while True:
            choice = int(
                input(
                    """Choose from the given options below-
1- Weight
2- Data
3- Length
4- Mass
5- Numeral System
6- Speed
7- Temperature
8- Currency conversion
9- Exit 
: """
                )
            )

            def http_status(choice):
                match choice:
                    case 1:
                        weight()
                    case 2:
                        data()
                    case 3:
                        length()
                    case 4:
                        mass()
                    case 5:
                        numeralSystem()
                    case 6:
                        speed()
                    case 7:
                        temperature()
                    case 8:
                        currencyConversion()
                    case 9:
                        exit()
                    case _:
                        print("Invalid Input !!!")
            http_status(choice)

    except Exception as e:
        print("Sorry, there's an unfortunate error. Try again")
        run()

def weight():
    try:
        choose = int(
            input(
                """Choose from the given list below-
1- To convert kgs to pounds
2- To convert pounds to kgs
3- Return to main menu
4- Exit - """
            )
        )

        def http_status(c):
            match c:
                case 1:
                    KtoP()
                case 2:
                    PtoK()
                case 3:
                    run()
                case 4:
                    exit()
                case _:
                    print("Invalid input, try again. ")
                    weight()
        http_status(choose)

    except Exception as e:
        print("Sorry, there's an unfortunate error. Try again")
        weight()

def KtoP():
    kg = float(input("KGs: "))
    print(f"{kg} kgs is equal to {kg * 2.20462:.2f} pounds")

def PtoK():
    pound = float(input("Pounds: "))
    print(f"{pound} pounds is equal to {pound / 2.20462:.2f} kgs")

def numeralSystem():
    try:
        choose = int(
            input(
                """Choose from the given list below-
1- To convert deca to deci
2- To convert hecto to deci
3- Return to main menu
4- Exit - """
            )
        )

        def http_status(c):
            match c:
                case 1:
                    decaTOdeci()
                case 2:
                    hectoTOdeci()
                case 3:
                    run()
                case 4:
                    exit()
                case _:
                    print("Invalid input, try again. ")
                    numeralSystem()
        http_status(choose)

    except Exception as e:
        print("Sorry, there's an unfortunate error. Try again")
        numeralSystem()

def decaTOdeci():
    deca = float(input("Deca: "))
    print(f"{deca} deca is equal to {deca * 10:.2f} deci")

def hectoTOdeci():
    hecto = float(input("Hecto: "))
    print(f"{hecto} hecto is equal to {hecto * 100:.2f} deci")

def mass():
    try:
        choose = int(
            input(
                """Choose from the given list below-
1- To convert kgs to tonnes
2- To convert grams to milligrams
3- Return to main menu
4- Exit - """
            )
        )

        def http_status(c):
            match c:
                case 1:
                    kgTOton()
                case 2:
                    grTOmil()
                case 3:
                    run()
                case 4:
                    exit()
                case _:
                    print("Invalid input, try again.")
                    mass()
        http_status(choose)

    except Exception as e:
        print("Sorry, there's an unfortunate error. Try again")
        mass()

def kgTOton():
    kg = float(input("KG: "))
    print(f"{kg} kgs is equal to {kg * 0.001:.3f} tonnes")

def grTOmil():
    gr = float(input("Grams: "))
    print(f"{gr} grams is equal to {gr * 1000:.0f} milligrams")

def speed():
    try:
        choose = int(
            input(
                """Choose from the given list below-
1- To convert kmph to mph
2- To convert mph to kmph
3- Return to main menu
4- Exit - """
            )
        )

        def http_status(c):
            match c:
                case 1:
                    kTOm()
                case 2:
                    mTOk()
                case 3:
                    run()
                case 4:
                    exit()
                case _:
                    print("Invalid input, try again.")
                    speed()
        http_status(choose)

    except Exception as e:
        print("Sorry, there's an unfortunate error. Try again")
        speed()

def kTOm():
    km = float(input("KM: "))
    print(f"{km} km is equal to {km * 0.621371:.2f} miles")

def mTOk():
    mil = float(input("Miles: "))
    print(f"{mil} miles is equal to {mil * 1.60934:.2f} km")

def data():
    try:
        choose = int(
            input(
                """Choose from the given list below-
1- To convert MBs to KBs
2- To convert TBs to GBs
3- Return to main menu
4- Exit - """
            )
        )

        def http_status(c):
            match c:
                case 1:
                    mbTOkb()
                case 2:
                    tbTOgb()
                case 3:
                    run()
                case 4:
                    exit()
                case _:
                    print("Invalid input, try again.")
                    data()
        http_status(choose)

    except Exception as e:
        print("Sorry, there's an unfortunate error. Try again")
        data()

def mbTOkb():
    mb = float(input("MB: "))
    print(f"{mb} MBs is equal to {mb * 1000:.0f} KBs")

def tbTOgb():
    tb = float(input("TB: "))
    print(f"{tb} TBs is equal to {tb * 1000:.0f} GBs")

def length():
    try:
        choose = int(
            input(
                """Choose from the given list below-
1- To convert feet to metres
2- To convert metres to inches
3- Return to main menu
4- Exit - """
            )
        )

        def http_status(c):
            match c:
                case 1:
                    FtoM()
                case 2:
                    MtoI()
                case 3:
                    run()
                case 4:
                    exit()
                case _:
                    print("Invalid input, try again.")
                    length()
        http_status(choose)

    except Exception as e:
        print("Sorry, there's an unfortunate error. Try again")
        length()

def FtoM():
    feet = float(input("Feet: "))
    print(f"{feet} feet is equal to {feet * 0.3048:.2f} metres")

def MtoI():
    metres = float(input("Metres: "))
    print(f"{metres} metres is equal to {metres * 39.3701:.2f} inches")

def temperature():
    try:
        c = int(
            input(
                """Choose from the given list below-
1- To convert celsius to fahrenheit
2- To convert fahrenheit to celsius
3- To convert celsius to kelvin
4- To convert kelvin to celsius
5- Return to the main menu
6- Exit - """
            )
        )

        def http_status(c):
            match c:
                case 1:
                    CtoF()
                case 2:
                    FtoC()
                case 3:
                    CtoK()
                case 4:
                    KtoC()
                case 5:
                    run()
                case 6:
                    exit()
                case _:
                    print("Invalid input, try again.")
                    temperature()
        http_status(c)

    except Exception as e:
        print("Sorry, there's an unfortunate error. Try again")
        temperature()

def CtoF():
    c = float(input("Celsius: "))
    print(f"{c}°C is equal to {(c * 9/5) + 32:.2f}°F")

def FtoC():
    f = float(input("Fahrenheit: "))
    print(f"{f}°F is equal to {(f - 32) * 5/9:.2f}°C")

def CtoK():
    c = float(input("Celsius: "))
    print(f"{c}°C is equal to {c + 273.15:.2f}K")

def KtoC():
    k = float(input("Kelvin: "))
    print(f"{k}K is equal to {k - 273.15:.2f}°C")

def currencyConversion():
    try:
        c = int(
            input(
                """Choose from the given list below to convert -
1- USD to EURO
2- EURO to USD
3- USD to INR
4- INR to USD
5- Return to main menu
6- Exit - """
            )
        )

        def http_status(c):
            match c:
                case 1:
                    print(currencyConversionRate("USD", "EUR"))
                case 2:
                    print(currencyConversionRate("EUR", "USD"))
                case 3:
                    print(currencyConversionRate("USD", "INR"))
                case 4:
                    print(currencyConversionRate("INR", "USD"))
                case 5:
                    run()
                case 6:
                    exit()
                case _:
                    print("Invalid input, try again.")
                    currencyConversion()
        http_status(c)

    except Exception as e:
        print("Sorry, there's an unfortunate error. Try again")
        currencyConversion()

def currencyConversionRate(from_curr, to_curr):
    try:
        c = CurrencyRates()
        conversion = c.get_rate(from_curr, to_curr)
        currency_codes = CurrencyCodes()
        currency_symbol = currency_codes.get_symbol(to_curr)
        return f"1 {from_curr} is equal to {conversion:.2f} {currency_symbol}"
    except RatesNotAvailableError:
        return "Exchange rate not available for the requested currencies. "
    except Exception as e:
        return f"An error occured : {e}"
run()
