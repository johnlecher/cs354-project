#!/bin/bash
echo
top -b -d 5 -n 1  | sed -n '7, ${s/^ *//;s/ *$//;s/  */,/gp;};$q'
echo