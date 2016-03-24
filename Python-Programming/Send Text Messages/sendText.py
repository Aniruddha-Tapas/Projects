#! python3
# textmyself.py - Defines the textmyself() function that texts a message
# passed to it as a string.

# Preset values:
from twilio.rest import TwilioRestClient

accountSID = 'ACcc14f2e1c2536af95d09666b2b1b9ae1'
authToken = '0e6900de963dcd374d9ffc4d38b30ad3'
myTwilioNumber = '+13344582573'
myCellPhone = '+917875087551'


def text(message):
    twilioCli = TwilioRestClient(accountSID, authToken)
    twilioCli.messages.create(body=message, from_=myTwilioNumber, to=myCellPhone)

text("Done!")
