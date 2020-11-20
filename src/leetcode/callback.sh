#!/bin/bash


while [[ $# -ge 1 ]]; do
    case $1 in
        -url|--url )
            A=$2
            echo "经过a"
            curl --request GET -sL \
                 --url $A
            ;;
          
    esac
    curl --request GET -sL \
         --url 'http://example.com'\
         --output './path/to/file'
done

