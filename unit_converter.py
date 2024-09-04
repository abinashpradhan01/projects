from forex_python.converter import CurrencyCodes, CurrencyRates


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
                                9- exit 
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
                                1- to convert kgs to pounds
                                2- to convert pounds to kgs
                                3- return to main menu
                                4- exit"""
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
                    print("Invalid input,try again. ")
                    weight()
        http_status(choose)

    except Exception as e:
        print("Sorry, there's an unfortunate error. Try again")
        weight()


def KtoP():
    kg = float(input("KGs : "))
    print(f"{kg} kgs is equal to {kg * 2.20462} pounds")


def PtoK():
    pound = float(input("Pounds : "))
    print(f"{pound} pounds is equal to {pound / 2.20462} kgs")


def numeralSystem():
    try:
        choose = int(
            input(
                """Choose from the given list below-
                                1- to convert deca to deci
                                2- to convert hecto to deci
                                3- return to main menu
                                4- exit"""
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
                    print("Invalid input,try again. ")
                    numeralSystem()
        http_status(choose)

    except Exception as e:
        print("Sorry, there's an unfortunate error. Try again")
        numeralSystem()


def decaTOdeci():
    deca = float(input("Deca : "))
    print(f"{deca} deca is equal to {deca * 10} deci")


def hectoTOdeci():
    hecto = float(input("Hecto : "))
    print(f"{hecto} hecto is equal to {hecto * 100} deci")


def mass():
    try:
        choose = int(
            input(
                """Choose from the given list below-
                                1- to convert kgs to tonnes
                                2- to convert grams to milligrams
                                3- return to main menu
                                4- exit"""
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
    kg = float(input("KG : "))
    print(f"{kg} kgs is equal to {kg * 0.001} tonnes")


def grTOmil():
    gr = float(input("Grams : "))
    print(f"{gr} grams is equal to {gr * 1000} milligrams")


def speed():
    try:
        choose = int(
            input(
                """Choose from the given list below-
                                1- to convert kmph to mph
                                2- to convert mph to kmph
                                3- return to main menu
                                4- exit"""
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
    km = float(input("KM : "))
    print(f"{km} km is equal to {km * 0.621371} miles")


def mTOk():
    mil = float(input("Miles : "))
    print(f"{mil} miles is equal to {mil * 1.60934} km")


def data():
    try:
        choose = int(
            input(
                """Choose from the given list below-
                                1- to convert MBs to KBs
                                2- to convert TBs to GBs
                                3- return to main menu
                                4- exit"""
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
    mb = float(input("MB : "))
    print(f"{mb} MBs is equal to {mb * 1000} KBs")


def tbTOgb():
    tb = float(input("TB : "))
    print(f"{tb} TBs is equal to {tb * 1000} GBs")


def length():
    try:
        choose = int(
            input(
                """Choose from the given list below-
                                1- to convert feet to metres
                                2- to convert metres to inches
                                3- return to main menu
                                4- exit"""
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
    feet = float(input("Feet : "))
    print(f"{feet} feet is equal to {feet * 0.3048} metres")


def MtoI():
    metres = float(input("Metres : "))
    print(f"{metres} metres is equal to {metres * 39.3701} inches")


def temperature():
    try:
        c = int(
            input(
                """Choose from the given list below-
                                        1- to convert celsius to fahrenheit
                                        2- to convert fahrenheit to celsius
                                        3- to convert celsius to kelvin
                                        4- to convert kelvin to celsius
                                        5- return to the main menu
                                        6- exit"""
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
    c = float(input("Celsius : "))
    print(f"{c}°C is equal to {(c * 9/5) + 32}°F")


def FtoC():
    f = float(input("Fahrenheit : "))
    print(f"{f}°F is equal to {(f - 32) * 5/9}°C")


def CtoK():
    c = float(input("Celsius : "))
    print(f"{c}°C is equal to {c + 273.15}K")


def KtoC():
    k = float(input("Kelvin : "))
    print(f"{k}K is equal to {k - 273.15}°C")


def currencyConversion():
    try:
        c = int(
            input(
                """Choose from the given list below to convert -
                                        1- USD to EURO
                                        2- EURO to USD
                                        3- USD to INR
                                        4- INR to USD
                                        5- return to main menu
                                        6- exit"""
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
    currency_rate = CurrencyRates()
    currency_symbol = CurrencyCodes().get_symbol(to_curr)
    conversion = currency_rate.convert(from_curr, to_curr, 1)
    return f"1 {from_curr} is equal to {conversion} {currency_symbol}"


run()
