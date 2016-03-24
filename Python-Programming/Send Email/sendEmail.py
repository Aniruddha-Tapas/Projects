#! python3
# sendDuesReminders.py - Sends emails based on their status in spreadsheet.

import smtplib, sys

# Log in to email account.
smtpObj = smtplib.SMTP('smtp.gmail.com', 587)
smtpObj.ehlo()
smtpObj.starttls()

##your-email = str('aniruddhastapas@gmail.com')
##your-password = str(aniruddha2)
##send-email-to = str('aniruddha@appliedprogramming.net')

smtpObj.login('aniruddhastapas@gmail.com', 'aniruddha2')

# Send out emails.
body = 'Specifically sent to yo via a python script'
print('Sending email...')
sendmailStatus = smtpObj.sendmail('aniruddhastapas@gmail.com','aniruddhastapas@gmail.com' ,body)

if sendmailStatus != {}:
    print('There was a problem sending email to %s: %s' % (your-email, sendmailStatus))
smtpObj.quit()
