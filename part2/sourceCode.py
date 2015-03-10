import random
import string

AlphaDic = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
NumDic = ['1','2','3','4','5','6','7','8','9','0']

class GenCommands():
        def  __init__(self,num,*args):
        #num is the number of the rows of the data you want to generate.
        #The first element in args is the name of the table.
        #then followed are the attribute name, type and length repeatly.
                if(len(args)<1): 
                        print "Wrong input"
                        return
                self.num = num
                self.tablename = args[0]
                self.attributes = []
                self.types = []
                self.description = []
		self.startNum = []
                for i in range(1,len(args)):
                        if(i%3 is 1): 
                                self.attributes.append(args[i])
                        elif(i%3 is 2):  
                                self.types.append(args[i])
                        else:
                                self.description.append(args[i])
				if args[i][0] == 's' and '-' not in args[i]:
					self.startNum.append(int(args[i][1:]))
				if args[i][0] == 's' and '-' in args[i]:
                                        string = args[i][2:-1]
                                        a=string.split('-')
                                        self.startNum.append(int(a[0]))
                self.genCommands()
                
        def genCommands(self):
        #This function is used for generating insert commands
                while(self.num):
			kk = -1
                        self.num = self.num-1
                        OutStr = "INSERT INTO "+self.tablename+" VALUES("
                        content_key = []
                        for i in range(len(self.attributes)):
                                is_key = 1 if (self.attributes[i][-4:] == '-KEY') else 0
				if self.description[i][0] == 's': 
					kk=kk+1
					startNum = self.startNum[kk]
					self.startNum[kk] = self.startNum[kk]+1
				else: startNum=0
                                if self.types[i] is "INT":
                                        content =self.geneInt(self.description[i],startNum,kk)
                                        while is_key and content in content_key:
                                                content =self.geneInt(self.description[i],startNum,kk)
                                        if is_key and content not in content_key: content_key.append(content)
                                        OutStr = OutStr + content+","
                                if self.types[i] is "string":
                                        content = self.geneStr(self.description[i])
                                        while is_key and content in content_key:
                                                content =self.geneStr(self.description[i])
                                        if is_key and content not in content_key: content_key.append(content)
                                        OutStr = OutStr + "\'"+content+"\',"
                                if self.types[i] is "INTstr":
                                        content = self.geneINTStr(self.description[i],startNum)
                                        while is_key and content in content_key:
                                                content =self.geneiINTStr(self.description[i],startNum)
                                        if is_key and content not in content_key: content_key.append(content)
                                        OutStr = OutStr + "\'"+content+"\',"
                                if self.types[i] is "date":
                                        content =self.geneDate(self.description[i])
                                        while is_key and content in content_key:
                                                content =self.geneDate(self.description[i])
                                        if is_key and content not in content_key: content_key.append(content)
                                        OutStr = OutStr +"\'"+ content+"\',"
                        OutStr = OutStr[0:-1] + ");"
                        print OutStr

        def geneInt(self, des, startNum,kk):
        # used for generating random values of int type
		if des[0] == 'r':
			length = int(des[1:])
			length = random.randint(1,length)
		elif des[0] == 'e':
			 length = int(des[1:])
		
		if des[0] == 'r' or des[0] == 'e':   
                	minNum = 1
                	maxNum = 9
                	for i in range(length):
                        	minNum = minNum * 10
                        	maxNum = maxNum * 10 + 9
                	return str(random.randint(minNum,maxNum))
		elif des[0] == 's':
                        if '-' in des:
                                string = des[2:-1]
                                a=string.split('-')
                                if int(startNum) == int(a[1]):
                                       self.startNum[kk] = int(a[0])
                                return str(startNum)
                        else:
                                return str(startNum) 
		elif des[0] == 'a' :
			string = des[2:-1]
			a=string.split('-')
			return str(random.randint(int(a[0]),int(a[1])))
		
	def geneDate(self, des):
        # used for generating random values of int type
		if des[0] == 'a' :
			string = des[2:-1]
			a=string.split('-')
			if('-' in string):
                                mm = random.randint(1,12)
                                dd = random.randint(1,28)
                                return str(random.randint(int(a[0]),int(a[1])))+ '-' + str(mm) +'-'+ str(dd)
                        else:
                                mm = random.randint(1,12)
                                dd = random.randint(1,28)
                                return string+ '-' + str(mm) +'-'+ str(dd)                 	
			
        def geneStr(self,des):
        # used for generating random values of string type
		if des[0] == 'r':
			length = int(des[1:])
			length = random.randint(1,length)
		elif des[0] == 'e':
			 length = int(des[1:])
		if des[0] == 'r' or des[0] == 'e':
                        length = random.randint(1,length)
                	out = ""
                	for i in range(length):
                        	out = out+random.choice(AlphaDic)
                	return out
		elif des[0] == 'a' :
			string = des[2:-1]
			a=string.split(',')
			return str(random.choice(a))

        def geneINTStr(self,des, startNum):
        #sometime, int type is not well used for long numbers; hence, for long number we use string to descrip it.
        # this function is used for generating a long number which is represented using string 
                if des[0] == 'r':
			length = int(des[1:])
			length = random.randint(1,length)
		elif des[0] == 'e':
			 length = int(des[1:])
		if des[0] == 'r' or des[0] == 'e':
                	if flag: 
                        	length = random.randint(1,length)
                	out = ""
                	for i in range(length):
                        	out = out+random.choice(NumDic)
                	return out
		elif des[0] == 's':
			return str(startNum)
		elif des[0] == 'a' :
			string = des[2:-1]
			a=string.split('-')
			return str(random.randint(int(a[0]),int(a[1])))




if __name__ == '__main__':
# you can generate the data you want as shown in the following command
# the first parameter is the number of the rows you want to generate;
# the second parameter is the name of the table you want to insert data in
# the following parameters are the description of the attributes of this table.
# you can insert the decription of as many as attributes you want. 

#The following several commands are used to generate the table of student where there are 200 students in each departement
        '''
	x = GenCommands(200,'student','UIN-KEY','INT','s8000','name','string','r20','BirthYear','INT','a[1985-1995]','Gender','string','a[F,M]','PHONE','INTstr','s9797396000','major','string','a[ECEN]','professor','INT','s[900-909]') # used to generat data of relation student
	x = GenCommands(200,'student','UIN-KEY','INT','s8200','name','string','r20','BirthYear','INT','a[1985-1995]','Gender','string','a[F,M]','PHONE','INTstr','s9797396200','major','string','a[CSCE]','professor','INT','s[910-919]') # used to generat data of relation student
	x = GenCommands(200,'student','UIN-KEY','INT','s8400','name','string','r20','BirthYear','INT','a[1985-1995]','Gender','string','a[F,M]','PHONE','INTstr','s9797396400','major','string','a[CE]','professor','INT','s[920-929]') # used to generat data of relation student
	x = GenCommands(200,'student','UIN-KEY','INT','s8600','name','string','r20','BirthYear','INT','a[1985-1995]','Gender','string','a[F,M]','PHONE','INTstr','s9797396600','major','string','a[ChE]','professor','INT','s[930-939]') # used to generat data of relation student
	x = GenCommands(200,'student','UIN-KEY','INT','s8800','name','string','r20','BirthYear','INT','a[1985-1995]','Gender','string','a[F,M]','PHONE','INTstr','s9797396800','major','string','a[MBS]','professor','INT','s[940-949]') # used to generat data of relation student
        '''
#The following several commands are used to generate the table of committeegroup
	'''
        x = GenCommands(200,'committeegroup','UIN-KEY','INT','s8000','chair','INT','s[900-909]','co-chair','INT','a[900-949]','defensedate','date','a[2014]','passed','string','a[Y,N]') # used to generat data of relation student
	x = GenCommands(200,'committeegroup','UIN-KEY','INT','s8200','chair','INT','s[910-919]','co-chair','INT','a[900-949]','defensedate','date','a[2014]','passed','string','a[Y,N]') # used to generat data of relation student
	x = GenCommands(200,'committeegroup','UIN-KEY','INT','s8400','chair','INT','s[920-929]','co-chair','INT','a[900-949]','defensedate','date','a[2014]','passed','string','a[Y,N]') # used to generat data of relation student
	x = GenCommands(200,'committeegroup','UIN-KEY','INT','s8600','chair','INT','s[930-939]','co-chair','INT','a[900-949]','defensedate','date','a[2014]','passed','string','a[Y,N]') # used to generat data of relation student
	x = GenCommands(200,'committeegroup','UIN-KEY','INT','s8800','chair','INT','s[940-949]','co-chair','INT','a[900-949]','defensedate','date','a[2014]','passed','string','a[Y,N]') # used to generat data of relation student
	'''
	
#The following command is used to generate the table of studyof
	#x = GenCommands(1000,'studyof','UIN-KEY','INT','s8000','courseID','string','a[ECEN01,ECEN02,CSCE01,CSCE02,CE01,CE02,ChE01,ChE02,MBS01,MBS02]','Score','INT','a[50-100]') 

#The following commands are used to generate the table of regersterin
	clubs='a[Poker,Music,Dance,Food,Travel,Hiking,Bascketball,Football]'
	x = GenCommands(200,'registerin','clubname-KEY','string',clubs,'studentUIN-KEY','INT','a[8000-8999]')
	
