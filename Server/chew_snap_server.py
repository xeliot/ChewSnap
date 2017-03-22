# -*- coding: utf-8 -*-
"""
Created on Thu Mar 16 22:56:13 2017

@author: Dave Ho
"""

from flask import Flask
from flask import request
import json as mjson
import ast
import sqlite3

app = Flask(__name__)
DATABASE = "chew_snap_database.db"

@app.route("/", methods=["GET", "POST"])
def hello():
    #if request.method == "GET":
    print "someone said get"
    return "What's up santosh"
    

@app.route("/login", methods=["GET", "POST"])
def request_login():
    print "user requesting login"
    print str(request.form)
    parameters = str(request.form)[22:]
    parameters = parameters[:-9]
    print parameters
    dic = ast.literal_eval(parameters)
    email = dic["email"]
    password = dic["password"]
    print (email +  " " + password)
    conn = sqlite3.connect(DATABASE)
    c = conn.cursor()
    c.execute("SELECT name FROM users WHERE email='"+email+"' AND password='"+password+"'")
    user = c.fetchone()[0]
    print user
    conn.close()
    if(not user):
        # user does not exist
        return "login_404_NOTFOUND"
    else:
        # user does exist
        return "login_200_FOUND " + user

@app.route("/signup", methods=["GET", "POST"])
def request_signup():
    print "user requesting signup"
    print str(request.form)
    parameters = str(request.form)[22:] #remove immutable dict tags
    parameters = parameters[:-9]
    print parameters
    dic = ast.literal_eval(parameters)
    name = dic["name"]
    email = dic["email"]
    password = dic["password"]
    print (name + " " + email + " " + password)
    conn = sqlite3.connect(DATABASE)
    c = conn.cursor()
    c.execute("SELECT * FROM users WHERE email='"+email+"'")
    user = c.fetchone()
    if(user != None):
        return "signup_409_USEREXISTS"
    else:
        c.execute('SELECT COUNT(userid) FROM users')
        count = c.fetchone()[0]
        c.execute("INSERT INTO users VALUES("+str(count)+", '"+name+"', '"+email+"', '"+password+"')")
        conn.commit()
        conn.close()
        return "signup_200_OK"

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=80)
    #app.run(host='0.0.0.0',port="80")