package com.bajajma.aoc2023;
 class SourceDestRange {
     long suppliedSourceStart, suppliedDestStart, range;
     SourceDestRange( String suppliedRange){
         String[] suppliedValues = suppliedRange.split(" ");
         suppliedDestStart = Integer.valueOf(suppliedValues[0]);
         suppliedSourceStart = Integer.valueOf(suppliedValues[1]);
         range = Integer.valueOf(suppliedValues[2]);


     }

     boolean isSourceInRange( long source) {
         return source >= suppliedSourceStart &&  source < ( suppliedSourceStart + range);
     }

     long getDest( int source) {
         if( isSourceInRange(source)) {
             return source-suppliedSourceStart+suppliedDestStart;
         }
         return -1;
     }


}
