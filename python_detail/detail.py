#------------------------------------------------
# detail class
# holds a single details information, including
# job, file, date, tags, etc information
class Detail:
  entry = 0
  job_name = ""
  job_number = ""
  date = 0
  global tags = ["detail"]
  
  def go(self):
		print ("detail class")
		return
	
  def contains(self, tag):
	  if tag in tags:
	    return True
	  return False
	
  def addTag(self, tag):
	  if tag in tags:
	    return False
	  tags.append(tag)
	  tags.sort()
	  return True


