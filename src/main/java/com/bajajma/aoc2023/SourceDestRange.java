package com.bajajma.aoc2023;
 class SourceDestRange {
     long suppliedSourceStart, suppliedDestStart, range;
     SourceDestRange( String suppliedRange){
         String[] suppliedValues = suppliedRange.split(" ");
         suppliedDestStart = Long.valueOf(suppliedValues[0]);
         suppliedSourceStart = Long.valueOf(suppliedValues[1]);
         range = Long.valueOf(suppliedValues[2]);


     }

     boolean isSourceInRange( long source) {
         return source >= suppliedSourceStart &&  source < ( suppliedSourceStart + range);
     }

     long getDest( long source) {
         if( isSourceInRange(source)) {
             return suppliedDestStart + (source-suppliedSourceStart);
         }
         return -1;
     }


}
