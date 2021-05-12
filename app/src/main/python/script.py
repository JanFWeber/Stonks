import pyEX

client = pyEX.Client(api_token = 'Tpk_340be1708c104fc592c0af6497509731', version ='sandbox')

def getSymbol(symbol):
    return symbol

def getPrice(symbol):
    return client.priceDF(symbol)

def getAdvancedStats(symbol):
    return client.advancedStats(symbol)

def getQuote(symbol):
    return client.quote(symbol)
