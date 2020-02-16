from bs4 import BeautifulSoup
import urllib.request
import numpy as np
import re
website = "http://contacts.ucalgary.ca/info/cpsc/contact-us/directory"
page = urllib.request.urlopen(website) 
path = "/Users/owner/Documents/new.txt"
soup = BeautifulSoup(page, features="html.parser")

#print(soup.prettify())

'''
all = soup.find_all("Professor")
for link in all:
	print(link.get("href"))
'''

all_tables=soup.find_all('table')
#print(all_tables)

data = []


keyword_list = ['Professor']

for i in range(25): 
	num = 'uofc-table-' + str(i+1)
	table = soup.find('table', id=(num))

	i = int(i) + 1
	table_body = table.find('tbody')
	rows = table_body.find_all('tr')

	for row in rows:
		cols = row.find_all('td')
		cols = [ele.text.strip() for ele in cols]

		cols = cols[0:2]

		for x in row.find_all('a', href = True):
			cols.append(x)
		for i in range(2):
			for x in cols:
				if x == '':
					cols.remove(x)
				

		cols = cols[0:3]
		#print(cols)

		data.append([ele for ele in cols if cols]) # Get rid of empty values

#print(data)






with open(path, 'w') as file:
	file.writelines('\t'.join(str(j) for j in i) + '\n' for i in data)



############### Part 2, iterating through everyone's website ###############

## filter for professors

#if thing in some_list: some_list.remove(thing)

print("\n")
print("\n")
print("\n")
print("\n")






## loop through all professors, can grab research interests

res = [i for i in data if "Professor" in i[1]]
print(res)
'''
path = "/Users/owner/Documents/Charlie.txt"
with open(path, 'w') as file:
	file.writelines('\t'.join(str(j) for j in i) + '\n' for i in res)
'''



## loop through website URLs and extract their research interests

website = "http://contacts.ucalgary.ca"


for x in res:
	#for a in x: regex searches all list of strings at once, searches all the time
	profileLink = re.search("<a href.*\">", str(x))
	if profileLink is not None:
		website = website + profileLink.group()[9:-2]

		page = urllib.request.urlopen(website) 
		soup = BeautifulSoup(page, features="html.parser")

		interest = []

		'''
		for a in soup.findAll("div", {"id": "unitis-profile-block-profileblock_0"}):
			interest = (list(a.stripped_strings)[1:])
		'''
		
		'''
		for a in soup.find_all('div', {"id": "unitis-profile-block-profileblock_0"}):
			interest.append(a.text)
			str1 = ''.join(interest)

			for b in str1.split(" "):
				interest.append(b)
		'''

		for a in soup.find_all('div', {"class": "unitis-profile-region-1"}):

			myList = (list(a.stripped_strings))
			if "Areas of Interest" in myList: 
				start = myList.index("Areas of Interest")
				if "Credentials" in myList:
					end = myList.index("Credentials")
					myList = myList[start+1:end]
				else:
					myList = myList[start+1:]
			else:
				myList = []
			print(myList)

		website = "http://contacts.ucalgary.ca"	
	else:
		print("Error 404")
	
	x.append(myList)
	str1 = ''.join(myList)



print(res)

path = "/Users/owner/Documents/final.txt"
with open(path, 'w') as file:
	file.writelines('\t'.join(str(j) for j in i) + '\n' for i in res)
