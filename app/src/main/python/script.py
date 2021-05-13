import pyEX

client = pyEX.Client(api_token = 'Tpk_340be1708c104fc592c0af6497509731', version ='sandbox')

def getSymbol(symbol):
    return symbol

def getPrice(symbol):
    return client.price(symbol)

def getAdvancedStats(symbol):
    return client.advancedStats(symbol)

def getQuote(symbol):
    return client.quote(symbol)

def getLogo(symbol):
    return client.logo(symbol)

getPrice("aapl")
getLogo("aapl")
